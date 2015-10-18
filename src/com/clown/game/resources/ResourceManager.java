package com.clown.game.resources;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

//Static methods
public final class ResourceManager {
	private static final Hashtable<String, Resource> resourceMap = new Hashtable<String, Resource>();
	
	static {
		File spriteFolder = new File(ResourceType.BASIC_SPRITE.getPath());
		for (File sprite : spriteFolder.listFiles()) {
			if (!sprite.isDirectory() && sprite.getName().contains(ResourceType.BASIC_SPRITE.getExtension())) {
				try {
					resourceMap.put(sprite.getName().replace(ResourceType.BASIC_SPRITE.getExtension(), ""), new Sprite(ImageIO.read(sprite)));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Resource getResource(String resourceName) {
		return resourceMap.get(resourceName);
	}
}
