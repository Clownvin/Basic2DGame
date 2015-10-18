package com.clown.game.resources;

public interface ResourceHolder {
	public static final int BACKGROUND = 0; // Background layer
	public static final int FOREGROUND = 2; // Foreground layer
	public static final int GAME_IMAGE = 1; // For things not on an above layer
	public Resource getResource();
	public int getLayer();
}
