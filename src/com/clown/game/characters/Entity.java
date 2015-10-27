package com.clown.game.characters;

import com.clown.game.map.Positioned;
import com.clown.game.resources.Resource;
import com.clown.game.resources.ResourceHolder;
import com.clown.util.IDTagSystem.IDTag;

//Entity for things like npcs, player, etc.
public abstract class Entity extends Positioned implements ResourceHolder {
	protected final IDTag idTag;
	protected Resource resource;
	
	public Entity(IDTag idTag) {
		this.idTag = idTag;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void destroy() {
		resource = null;
		idTag.returnTag(); //Go on tag, get back in the system.
	}
}
