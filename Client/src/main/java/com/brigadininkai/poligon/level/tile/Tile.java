package com.brigadininkai.poligon.level.tile;

import com.brigadininkai.poligon.graphics.Screen;
import com.brigadininkai.poligon.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile GRASS = new BasicTile(Sprite.grass);
	public static Tile VOID = new VoidTile(Sprite.voidSprite);
	public static Tile FLOOR = new BasicTile(Sprite.floor);
	public static Tile ROCK = new BasicSolidTile(Sprite.rock);
	public static Tile TREE = new BasicSolidTile(Sprite.tree);
	public static Tile STONE_WALL = new BasicSolidTile(Sprite.stone_wall);
	public static Tile WHITE_BRICK_WALL = new BasicSolidTile(Sprite.white_brick_wall);
	public static Tile BLUE_BRICK_WALL = new BasicSolidTile(Sprite.blue_brick_wall);
	public static Tile RED_BRICK_WALL = new BasicSolidTile(Sprite.red_brick_wall);
	
	public static final int COL_GRASS = 0xff00ff00;
	public static final int COL_FLOOR = 0xffa9612c;
	public static final int COL_BLUE_BRICK_WALL = 0xff787878;
	public static final int COL_RED_BRICK_WALL = 0xff552908;
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}
}
