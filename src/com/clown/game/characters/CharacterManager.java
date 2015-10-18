package com.clown.game.characters;

import java.util.ArrayList;

import com.clown.game.util.Configuration;
import com.clown.util.IDTagSystem;

//Static methods
public final class CharacterManager {
	private static final IDTagSystem characterTagger = new IDTagSystem(Configuration.MAX_CHARACTERS);
	private static final Player player = new Player(characterTagger.getTag());
	private static final ArrayList<Entity> characters = new ArrayList<Entity>();
}
