package com.brigadininkai.poligon.level.tile;

import com.brigadininkai.poligon.graphics.Screen;
import com.brigadininkai.poligon.graphics.Sprite;

public class BasicSolidTile extends Tile {

	public BasicSolidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean solid() {
		return true;
	}

}
