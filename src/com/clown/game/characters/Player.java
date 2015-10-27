package com.clown.game.characters;

import com.clown.game.resources.ResourceManager;
import com.clown.util.IDTagSystem.IDTag;

public class Player extends Character {
	public Player(IDTag idTag) {
		super(idTag);
		resource = ResourceManager.getResource("playertestsprite");
	}
	
	//X and Y should be change, not actual values of x/y;
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
		System.out.println("Moved player to ("+x+", "+y+").");
	}
}