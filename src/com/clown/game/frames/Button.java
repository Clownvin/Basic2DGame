package com.clown.game.frames;

import com.clown.game.resources.Resource;
import com.clown.game.resources.ResourceHolder;
import com.clown.game.resources.Sprite;

public class Button extends Interactable {
	public Button(int x, int y, Resource resource) {
		this.resource = resource;
		this.x = x;
		this.y = y;
		width = ((Sprite)resource).getWidth();
		height = ((Sprite)resource).getHeight();
	}

	@Override
	public int getLayer() {
		return ResourceHolder.FOREGROUND;
	}
}
