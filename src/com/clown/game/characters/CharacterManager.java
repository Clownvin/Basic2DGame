package com.clown.game.characters;

import java.util.ArrayList;

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
	
	public static ArrayList<Entity> getResourceHolders() {
		ArrayList<Entity> listCopy = new ArrayList<Entity>(characters.size() + 1);
		listCopy.addAll(characters);
		listCopy.add(player);
		return listCopy;
	}
}
