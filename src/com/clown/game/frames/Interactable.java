package com.clown.game.frames;
import java.util.Hashtable;

import com.clown.game.resources.Resource;
import com.clown.game.resources.ResourceHolder;

public abstract class Interactable implements ResourceHolder {
	public static final int MOUSE_RELEASE = 1;
	public static final int MOUSE_DRAG = 2;
	public static final int MOUSE_OVER = 3;
	//Every other actionID should correspond to a keyEvent
	protected final Hashtable<Integer, Action> actionTable = new Hashtable<Integer, Action>();
	protected Resource resource;
	protected int x = 0, y = 0, width = 0, height = 0;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setAction(int actionID, Action action) {
		actionTable.put(actionID, action);
	}
	
	public void performAction(int actionID) {
		actionTable.get(actionID).perform();
	}
	
	public boolean pointInsideArea(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}
	
	@Override
	public Resource getResource() {
		return resource;
	}
}
