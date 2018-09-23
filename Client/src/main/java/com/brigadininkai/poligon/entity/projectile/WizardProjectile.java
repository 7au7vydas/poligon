package com.brigadininkai.poligon.entity.projectile;

import com.brigadininkai.poligon.entity.spawner.ParticleSpawner;
import com.brigadininkai.poligon.graphics.Screen;
import com.brigadininkai.poligon.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 10;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		demage = 20;
		sprite = Sprite.wizard_projectile;
		xOffset = 4;
		yOffset = 4;
		size = 7;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision((int) (x + nx), (int) (y + ny), size, xOffset, yOffset)) {
			level.add(new ParticleSpawner((int) x, (int) y, 150, 400, level));
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;

	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 10, (int) y - 12, this);
	}
}
