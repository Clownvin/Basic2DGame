package com.clown.game.io;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
	}
}
