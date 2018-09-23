package com.brigadininkai.poligon.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public final int WIDTH, HEIGHT;
	public int[] sSPixels;

	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/sprite_sheet.png", 256);
	public static SpriteSheet wizard_projectiles = new SpriteSheet("/textures/sheets/projectiles/wizard.png", 48);

	public static SpriteSheet player = new SpriteSheet("/textures/sheets/Player_SpriteSheet.png", 128, 96);
	public static SpriteSheet player_down = new SpriteSheet(player, 2, 0, 3, 1, 32);
	public static SpriteSheet player_up = new SpriteSheet(player, 0, 0, 3, 1, 32);
	public static SpriteSheet player_left = new SpriteSheet(player, 3, 0, 3, 1, 32);
	public static SpriteSheet player_right = new SpriteSheet(player, 1, 0, 3, 1, 32);
	
	public static Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int height, int width, int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		this.WIDTH = w;
		this.HEIGHT = h;
		if (width == height) this.SIZE = width;
		else
			this.SIZE = -1;
		sSPixels = new int[w * h];
		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				sSPixels[x0 + y0 * w] = sheet.sSPixels[xp + yp * sheet.WIDTH];
			}
		}
//		int frame = 0;
//		for (int ya = 0; ya < height; ya++) {
//			for (int xa = 0; xa < width; xa++){
//				int[] spritePixels = new int[spriteSize*spriteSize];
//				for(int y0 = 0; y0 < h; y0++) {
//					for (int x0 = 0; x0 < w; x0++) {
//						spritePixels[x0 + y0 * spriteSize] = sSPixels[(x0 + xa * spriteSize) + (y0 + ya * spriteSize) * WIDTH];
//					}
//				}
//				Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
//				sprites[frame++] = sprite;
//			}
//		}
		}
		

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.WIDTH = size;
		this.HEIGHT = size;
		sSPixels = new int[WIDTH * HEIGHT];
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.SIZE = -1;
		this.WIDTH = width;
		this.HEIGHT = height;
		sSPixels = new int[WIDTH * HEIGHT];
		load();
	}
	
	public Sprite[] getSprites() {
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, sSPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
