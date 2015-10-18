package com.clown.game.resources;

import java.util.Hashtable;

//Static methods
public final class ResourceManager {
	private static final Hashtable<String, Resource> resourceMap = new Hashtable<String, Resource>();
	
	public static Resource getResource(String resourcePath) {
		return resourceMap.get(resourcePath);
	}
}
