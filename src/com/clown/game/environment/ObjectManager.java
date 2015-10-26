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
	
	public static ArrayList<ResourceHolder> getResourceHolders() {
		ArrayList<ResourceHolder> resourceHolders = new ArrayList<ResourceHolder>(objects.size());
		resourceHolders.addAll(objects); // Assuming this is faster than whatever it was I was about to write
		return resourceHolders;
	}
	
	public static void despawnInArea(int x1, int y1, int x2, int y2) {
		for (int i = 0; i < objects.size(); i++) {
			EnvironmentObject object = objects.get(i);
			if (object.getX() >= x1 && object.getX() <= x2 && object.getY() >= y1 && object.getY() <= y2) {
				object.destroy();
				objects.remove(i--);
			}
		}
	}
}
