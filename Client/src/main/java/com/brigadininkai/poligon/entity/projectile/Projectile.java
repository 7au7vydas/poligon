package com.brigadininkai.poligon.entity.projectile;

import com.brigadininkai.poligon.entity.Entity;
import com.brigadininkai.poligon.graphics.Sprite;

public abstract class Projectile extends Entity {
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, demage, range;
	protected int xOffset, yOffset, size;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getSpriteSize() {
		return sprite.SIZE;
	}

	protected void move() {

	}
}
