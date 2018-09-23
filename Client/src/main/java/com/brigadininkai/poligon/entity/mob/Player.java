package com.brigadininkai.poligon.entity.mob;

import com.brigadininkai.poligon.Game;
import com.brigadininkai.poligon.entity.projectile.Projectile;
import com.brigadininkai.poligon.entity.projectile.WizardProjectile;
import com.brigadininkai.poligon.graphics.Screen;
import com.brigadininkai.poligon.graphics.Sprite;
import com.brigadininkai.poligon.input.Keyboard;
import com.brigadininkai.poligon.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	private int fireRate = 0;

	public Player(Keyboard input) {
		this.input = input;
		this.sprite = Sprite.player_up;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.sprite = Sprite.player_up;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public void update() {
		if (fireRate > 0) fireRate--;
		int xa = 0, ya = 0;
		if (anim < 75000) anim++;
		else
			anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
//		if(Mouse.getButton() == 3) teleport(Mouse.getX() - Game.getWindowWidth()/2, Mouse.getY() - Game.getWindowHeight()/2);
//		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooing();

	}
//	private void teleport(double x, double y) {
//		this.x = (int)x;
//		this.y = (int)y;
//	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	private void updateShooing() {
		
		
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
		
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.player_up;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking) {
				if (anim % 40 < 10) {
					sprite = Sprite.player_right_1;
				} else if (anim % 40 > 10 && anim % 40 < 20) {
					sprite = Sprite.player_right;
				} else if (anim % 40 > 20 && anim % 40 < 30) {
					sprite = Sprite.player_right_2;
				} else {
					sprite = Sprite.player_right;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_down;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking) {
				if (anim % 40 < 10) {
					sprite = Sprite.player_left_1;
				} else if (anim % 40 > 10 && anim % 40 < 20) {
					sprite = Sprite.player_left;
				} else if (anim % 40 > 20 && anim % 40 < 30) {
					sprite = Sprite.player_left_2;
				} else {
					sprite = Sprite.player_left;
				}
			}
		}
		screen.renderPlayer(x - sprite.SIZE / 2, y - sprite.SIZE / 2, sprite);
	}
}
