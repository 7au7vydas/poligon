package com.brigadininkai.poligon.graphics;

import java.awt.Color;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] sPixels;
	protected SpriteSheet sheet;

	//Level sprites
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, Color.BLUE.getRGB());
	public static Sprite floor = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite tree = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite stone_wall = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite white_brick_wall = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite blue_brick_wall = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite red_brick_wall = new Sprite(16, 2, 0, SpriteSheet.tiles);

	// Player sprites
	public static Sprite player_up = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 1, 5, SpriteSheet.tiles);

	public static Sprite player_up_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_down_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_left_1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite player_right_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);

	public static Sprite player_up_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(32, 3, 7, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	//Projectile sprites 
	public static Sprite wizard_projectile = new Sprite(16, 0, 0, SpriteSheet.wizard_projectiles);

	//Particle sprites 
	public static Sprite normal_particle = new Sprite(3, 0xbebebe);

	protected Sprite(SpriteSheet sheet, int width, int height) {
		if (width == height) SIZE = width;
		else
			SIZE = -1;
		this.width = width;;
		this.height =height;
		this.sheet = sheet;
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.height = size;
		this.width = size;
		sPixels = new int[height * width];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int colour) {
		this.SIZE = -1;
		this.width = width;
		this.height = height;
		sPixels = new int[height * width];
		setColour(colour);
	}

	public Sprite(int size, int colour) {
		this.SIZE = size;
		this.height = size;
		this.width = size;
		this.sPixels = new int[height * width];
		setColour(colour);
	}

	public Sprite(int[] pixels, int width, int height) {
		if (width == height) SIZE = width;
		else
			SIZE = -1;
		this.width = width;
		this.height = height;
		this.sPixels = pixels;
	}

	private void setColour(int colour) {
		for (int i = 0; i < width * height; i++) {
			sPixels[i] = colour;
		}
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				sPixels[x + y * SIZE] = sheet.sSPixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
