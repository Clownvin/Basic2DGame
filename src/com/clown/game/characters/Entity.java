package com.clown.game.characters;

import com.clown.game.environment.EnvironmentObject;
import com.clown.util.IDTagSystem.IDTag;

//Entity for things like npcs, player, etc.
public abstract class Entity extends EnvironmentObject {

	public Entity(IDTag idTag) {
		super(idTag);
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
