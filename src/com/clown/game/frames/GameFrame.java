package com.clown.game.frames;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import com.clown.game.characters.CharacterManager;
import com.clown.game.environment.ObjectManager;
import com.clown.game.resources.ResourceHolder;

public final class GameFrame extends Frame {
	private static final GameFrame gameFrame = new GameFrame();
	
	//To prevent outside instantiation.
	private GameFrame() {
		
	}
	
	private static final KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
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
		ArrayList<ResourceHolder> resourceHolders = CharacterManager.getResourceHolders();
		resourceHolders.addAll(ObjectManager.getResourceHolders());
		
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
