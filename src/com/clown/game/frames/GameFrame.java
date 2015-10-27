package com.clown.game.frames;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

import com.clown.game.Game;
import com.clown.game.characters.CharacterManager;
import com.clown.game.characters.Entity;
import com.clown.game.environment.ObjectManager;
import com.clown.game.map.Positioned;
import com.clown.game.resources.Sprite;
import com.clown.game.util.Configuration;

public final class GameFrame extends Frame {
	private static final GameFrame gameFrame = new GameFrame();
	
	//To prevent outside instantiation.
	private GameFrame() {
		
	}
	
	private static final KeyAdapter keyAdapter = new KeyAdapter() {
		//TODO Change to keypressed and set a boolean. Keep incrementing until keyreleased
		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				Game.setFrame(StartFrame.getFrame());
				break;
			case KeyEvent.VK_W:
				CharacterManager.getPlayer().move(0, -128);
				break;
			case KeyEvent.VK_S:
				CharacterManager.getPlayer().move(0, 128);
				break;
			case KeyEvent.VK_A:
				CharacterManager.getPlayer().move(-128, 0);
				break;
			case KeyEvent.VK_D:
				CharacterManager.getPlayer().move(128, 0);
				break;
			}
		}
	};
	
	private static final MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			int mouseX = e.getX(), mouseY = e.getY();
			System.out.println("MouseX: "+mouseX+", MouseY: "+mouseY);
			for (Interactable interactable : interactables) {
				if (interactable.pointInsideArea(mouseX, mouseY)) {
					interactable.performAction(Interactable.MOUSE_RELEASE);
					return;
				}
			}
		}
	};
	
	public static GameFrame getFrame() {
		return gameFrame;
	}

	@Override
	public void paint(Graphics g) {
		ArrayList<Entity> list = new ArrayList<Entity>(Configuration.MAX_CHARACTERS + Configuration.MAX_OBJECTS);
		list.addAll(ObjectManager.getResourceHolders());
		list.addAll(CharacterManager.getResourceHolders());
		list.sort(new Comparator<Entity>() {
			@Override
			public int compare(Entity o1, Entity o2) {
				int diff = o2.getLayer() - o1.getLayer(); // Layer primary
				if (diff == 0) {
					return ((Positioned)o2).compareTo(o1); // Sort by position on screen.
				}
				return diff;
			}
		});
		
		//TODO Make Sprite widths all the same. Determine a size for sprites. I'm thinking 64 or 32. 32 would be small, but small = complex = advanced looking. Might have to keep it 64 though
		int widthFix = (Game.getGame().getWidth() / 2) - 64;
		int heightFix = (Game.getGame().getHeight() / 2) - 64;
		//TODO Add culling of sprites not within screen bounds.
		for (Entity e : list) {
			//TODO Make Entity.getX()/getY() perform the subtraction and width fix automatically.
			g.drawImage(((Sprite)e.getResource()).getImage(), (e.getX() - CharacterManager.getPlayer().getX()) + widthFix, (e.getY() - CharacterManager.getPlayer().getY()) + heightFix, null);
		}
	}

	//Consider adding things like save game right here.
	@Override
	public void destroy() {
		System.out.println("GameFrame destroy called.");
	}

	@Override
	public KeyAdapter getKeyAdapter() {
		return keyAdapter;
	}

	@Override
	public MouseAdapter getMouseAdapter() {
		return mouseAdapter;
	}

}
