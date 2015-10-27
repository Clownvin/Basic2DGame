package com.clown.game.environment;

import com.clown.game.resources.ResourceManager;
import com.clown.util.IDTagSystem.IDTag;

public class StaticObject extends EnvironmentObject {

	public StaticObject(IDTag idTag, int x, int y, String resourceName) {
		super(idTag);
		this.x = x;
		this.y = y;
		this.resource = ResourceManager.getResource(resourceName);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
