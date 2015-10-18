package com.clown.game.environment;

import java.util.ArrayList;

import com.clown.game.resources.ResourceHolder;

//Static methods
public final class ObjectManager {
	//Consider using a different type of collection object.
	private static final ArrayList<EnvironmentObject> objects = new ArrayList<EnvironmentObject>();
	
	public static EnvironmentObject getObjectAt(int x, int y) {
		for (EnvironmentObject object : objects) {
			if (object.getX() == x && object.getY() == y) {
				return object;
			}
		}
		return null;
	}
	
	public static ArrayList<ResourceHolder> getObjects() {
		ArrayList<ResourceHolder> resourceHolders = new ArrayList<ResourceHolder>(objects.size());
		resourceHolders.addAll(objects); // Assuming this is faster than whatever it was I was about to write
		return resourceHolders;
	}
}
