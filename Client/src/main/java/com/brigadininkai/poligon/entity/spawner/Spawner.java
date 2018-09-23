package com.brigadininkai.poligon.entity.spawner;

import com.brigadininkai.poligon.entity.Entity;
import com.brigadininkai.poligon.level.Level;

public class Spawner extends Entity {
	
	public enum Type {
		PARTICLE, MOB;
	}
	private Type type;
	
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
}
