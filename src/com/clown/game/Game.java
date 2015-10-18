package com.clown.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.clown.game.frames.Frame;
import com.clown.game.frames.StartFrame;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046706410077622017L;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	
	private static BufferedImage drawingImage;
	private static Graphics2D imageGraphics;
	private static Frame currentFrame = null;
	
	private Game() {
		this.setUndecorated(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		for (GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
			if (device.isFullScreenSupported()) {
				device.setFullScreenWindow(game);
			}
		}
		setFrame(new StartFrame());
		while (true) {
			game.repaint();
		}
	}
	
	public static void setFrame(Frame frame) {
		currentFrame = frame;
	}
	
	//Should be the only non-static method other than the constructor and other overridden methods
	@Override
	public void paint(Graphics g) {
		if (drawingImage == null || imageGraphics == null) {
			drawingImage = (BufferedImage) createImage(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
			imageGraphics = (Graphics2D) drawingImage.getGraphics();
		}
		//Clear screen of junk
		imageGraphics.setColor(BACKGROUND_COLOR);
		imageGraphics.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		//Paint current frame
		if (currentFrame != null) {
			currentFrame.paint(imageGraphics);
		}
		//Draw image to graphics
		g.drawImage(drawingImage, 0, 0, null);
	}
}
