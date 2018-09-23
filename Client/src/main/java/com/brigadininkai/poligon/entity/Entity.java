package com.brigadininkai.poligon.entity;

import java.util.Random;

import com.brigadininkai.poligon.graphics.Screen;
import com.brigadininkai.poligon.level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected Random random = new Random();

	public void update() {

	}

	public void render(Screen screen) {
	}

	public void remove() {
		//remove from level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) {
		this.level = level;
	}
}
