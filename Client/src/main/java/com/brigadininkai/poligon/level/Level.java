package com.brigadininkai.poligon.level;

import java.util.ArrayList;
import java.util.List;

import com.brigadininkai.poligon.entity.Entity;
import com.brigadininkai.poligon.level.tile.Tile;
import com.brigadininkai.poligon.entity.particles.Particle;
import com.brigadininkai.poligon.entity.projectile.Projectile;
import com.brigadininkai.poligon.graphics.Screen;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	public static Level spawn_level = new SpawnLevel("/levels/spawn_level.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		GenerateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		GenerateLevel();
	}

	protected void loadLevel(String path) {
	}

	protected void GenerateLevel() {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) particles.remove(i);
		}
	}

	private void time() {
	}

	public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size + xOffset) >> 4;
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if (getTile((int) xt, (int) yt).solid()) solid = true;
		}
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}

	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else {
			entities.add(e);
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// Rock = 0xff7f7f00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.VOID;
		if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.GRASS;
		if (tiles[x + y * width] == Tile.COL_FLOOR) return Tile.FLOOR;
		if (tiles[x + y * width] == Tile.COL_BLUE_BRICK_WALL) return Tile.BLUE_BRICK_WALL;
		if (tiles[x + y * width] == Tile.COL_RED_BRICK_WALL) return Tile.RED_BRICK_WALL;
		return Tile.VOID;
	}

}
