package com.clown.game.resources;

import java.awt.image.BufferedImage;

public class Sprite extends Resource {
	private static final ResourceType type = ResourceType.BASIC_SPRITE;
	private final BufferedImage spriteImage;
	
	public Sprite(BufferedImage spriteImage) {
		this.spriteImage = spriteImage;
	}
	
	public BufferedImage getImage() {
		return spriteImage;
	}
	
	@Override
	public ResourceType getResourceType() {
		return type;
	}
	
	public int getWidth() {
		return spriteImage.getWidth();
	}
	
	public int getHeight() {
		return spriteImage.getHeight();
	}
}
