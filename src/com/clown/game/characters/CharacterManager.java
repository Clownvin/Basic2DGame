package com.clown.game.characters;

import java.util.ArrayList;

import com.clown.game.resources.ResourceHolder;
import com.clown.game.util.Configuration;
import com.clown.util.IDTagSystem;

//Static methods
public final class CharacterManager {
	private static final IDTagSystem characterTagger = new IDTagSystem(Configuration.MAX_CHARACTERS);
	private static final Player player = new Player(characterTagger.getTag());
	private static final ArrayList<Entity> characters = new ArrayList<Entity>();
	
	private CharacterManager() {
		//Never need to instantiate this.
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static Entity getCharacterAt(int x, int y) {
		for (Entity character : characters) {
			if (character.getX() == x && character.getY() == y) {
				return character;
			}
		}
		return null;
	}
	
	public static ArrayList<ResourceHolder> getResourceHolders() {
		ArrayList<ResourceHolder> resourceHolders = new ArrayList<ResourceHolder>(characters.size());
		resourceHolders.addAll(characters); // Assuming this is faster than whatever it was I was about to write
		return resourceHolders;
	}
}
