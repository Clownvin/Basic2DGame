package com.clown.game.characters;

import com.clown.game.resources.ResourceManager;
import com.clown.util.IDTagSystem.IDTag;

public class Player extends Entity {
	public Player(IDTag idTag) {
		super(idTag);
		resource = ResourceManager.getResource("playertestsprite");
	}
}