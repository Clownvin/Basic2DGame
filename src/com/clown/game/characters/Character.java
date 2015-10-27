package com.clown.game.characters;

import com.clown.game.resources.ResourceHolder;
import com.clown.util.IDTagSystem.IDTag;

public abstract class Character extends Entity {

	public Character(IDTag idTag) {
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
	
	@Override
	public int getLayer() {
		return ResourceHolder.GAME_IMAGE;
	}
}
