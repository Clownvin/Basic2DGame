package com.clown.game.frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public final class StartFrame extends Frame {

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 200, 400, 400, 50);
		g.drawString("Exit", (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 160, 420);
	}
}
