package com.clown.game.frames;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.clown.game.Game;
import com.clown.game.resources.Resource;
import com.clown.game.resources.ResourceManager;
import com.clown.game.resources.Sprite;

public final class StartFrame extends Frame {
	private static final StartFrame singleton = new StartFrame();
	
	//Prevent outside instantiation
	private StartFrame() {
		//Add interactables here.
		Resource buttonResource = ResourceManager.getResource("startbutton");
		Button startButton = new Button((Game.getGame().getWidth() / 2) - (((Sprite)buttonResource).getWidth() /2), 400, buttonResource);
		startButton.setAction(Interactable.MOUSE_RELEASE, new Action() {
			@Override
			public void perform() {
				System.out.println("Clicked me!");
			}
		});
		Resource exitButtonResource = ResourceManager.getResource("exitbutton");
		Button exitButton = new Button(startButton.getX(), startButton.getY()+startButton.getHeight(), exitButtonResource);
		exitButton.setAction(Interactable.MOUSE_RELEASE, new Action() {
			@Override
			public void perform() {
				System.exit(0);
			}
		});
		interactables.add(startButton);
		interactables.add(exitButton);
	}
	
	public static StartFrame getFrame() {
		return singleton;
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
	
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < 3; i++) {
			for (Interactable interactable : interactables) {
				if (interactable.getLayer() == i) {
					g.drawImage(((Sprite)interactable.getResource()).getImage(), interactable.getX(), interactable.getY(), null);
				}
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("Startframe destroyed");
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
