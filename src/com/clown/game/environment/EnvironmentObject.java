package com.clown.game.environment;

import com.clown.game.resources.Resource;
import com.clown.util.IDTagSystem.IDTag;

//Environment object for general objects
public abstract class EnvironmentObject implements Comparable<EnvironmentObject> {
	protected int x, y;
	protected Resource objectResource;
	protected final IDTag idTag;
	
	public EnvironmentObject(IDTag idTag) {
		this.idTag = idTag;
	}
	
	public IDTag getIDTag() {
		return idTag;
	}
	
	public abstract int getX(); // Each object type will define this on their own.
	
	public abstract int getY(); // Each object type will define this on their own.
	
	public void destroy() {
		objectResource = null;
		idTag.returnTag(); //Go on tag, get back in the system.
	}
	
	@Override
	public int compareTo(EnvironmentObject object) {
		return object.getIDTag().getID() - idTag.getID();
	}
}