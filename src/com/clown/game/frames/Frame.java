package com.clown.game.frames;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public abstract class Frame {
	protected static final ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	
	public abstract void paint(Graphics g);
	
	public abstract void destroy();
	
	public abstract KeyAdapter getKeyAdapter();
	
	public abstract MouseAdapter getMouseAdapter();
}
