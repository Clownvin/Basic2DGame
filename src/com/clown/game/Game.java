package com.clown.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.clown.game.frames.Frame;
import com.clown.game.frames.StartFrame;
import com.clown.game.resources.ResourceManager;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046706410077622017L;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final Game game = new Game();
	
	private static BufferedImage drawingImage;
	private static Graphics2D imageGraphics;
	private static Frame currentFrame = null;
	private static KeyAdapter keyAdapter = null;
	private static MouseAdapter mouseAdapter = null;
	
	private Game() {
		this.setUndecorated(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		System.out.println(ResourceManager.getResource("mossyrock1") == null ? "Sprites not loaded" : "Sprites loaded");
		for (GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
			if (device.isFullScreenSupported()) {
				device.setFullScreenWindow(game);
			}
		}
		setFrame(StartFrame.getFrame());
		//Update every 16 milliseconds, not all the time.
		//Add other game loop stuff.
		while (true) {
			game.repaint();
		}
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static void setFrame(Frame frame) {
		if (currentFrame != null) {
			game.removeKeyListener(currentFrame.getKeyAdapter());
			game.removeMouseListener(currentFrame.getMouseAdapter());
			currentFrame.destroy();
		}
		currentFrame = frame;
		keyAdapter = frame.getKeyAdapter();
		mouseAdapter = frame.getMouseAdapter();
		game.addKeyListener(keyAdapter);
		game.addMouseListener(mouseAdapter);
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
