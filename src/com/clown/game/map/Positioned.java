package com.clown.game.map;

public abstract class Positioned implements Comparable<Positioned> {
	protected int x, y;
	
	public abstract int getX();
	
	public abstract int getY();
	
	@Override
	public int compareTo(Positioned object) {
		int difference = object.getX() - x;
		if (difference == 0) {
			return object.getY() - y;
		}
		return difference;
	}
}
