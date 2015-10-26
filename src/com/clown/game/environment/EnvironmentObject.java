package com.clown.game.environment;

import com.clown.game.map.Positioned;
import com.clown.game.resources.Resource;
import com.clown.game.resources.ResourceHolder;
import com.clown.util.IDTagSystem.IDTag;

//Environment object for general objects
public abstract class EnvironmentObject extends Positioned implements ResourceHolder {
	protected Resource resource;
	protected final IDTag idTag;
	
	public EnvironmentObject(IDTag idTag) {
		this.idTag = idTag;
	}
	
	public IDTag getIDTag() {
		return idTag;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public abstract int getX(); // Each subclass will define this on their own.
	
	public abstract int getY(); // Each subclass will define this on their own.
	
	public void destroy() {
		resource = null;
		idTag.returnTag(); //Go on tag, get back in the system.
	}
	
	@Override
	public int getLayer() {
		return ResourceHolder.GAME_IMAGE;
	}
}