package com.clown.game.resources;

public enum ResourceType {
	BASIC_SPRITE("./data/sprites/", ".png");
	private final String path;
	private final String extension;
	private ResourceType(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getExtension() {
		return extension;
	}
}
