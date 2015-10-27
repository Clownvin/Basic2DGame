package com.clown.game.environment;

import java.util.ArrayList;

import com.clown.game.characters.Entity;
import com.clown.game.util.Configuration;
import com.clown.util.IDTagSystem;

//Static methods
public final class ObjectManager {
	//Consider using a different type of collection object.
	private static final IDTagSystem tagger = new IDTagSystem(Configuration.MAX_OBJECTS);
	private static final ArrayList<EnvironmentObject> objects = new ArrayList<EnvironmentObject>();
	
	static {
		//For testing purposes only
		for (int x = 0; x < 18 * 128; x += 128) {
			for (int y = 0; y < 18 * 128; y += 128) {
				objects.add(new StaticObject(tagger.getTag(), x, y, "mossyrock1"));
			}
		}
	}
	
	public static EnvironmentObject getObjectAt(int x, int y) {
		for (EnvironmentObject object : objects) {
			if (object.getX() == x && object.getY() == y) {
				return object;
			}
		}
		return null;
	}
	
	public static ArrayList<Entity> getResourceHolders() {
		ArrayList<Entity> listCopy = new ArrayList<Entity>(objects.size());
		listCopy.addAll(objects);
		return listCopy;
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
