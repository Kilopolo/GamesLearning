package com.gmail.pablo23dr.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	
	
	public Player(int x, int y, ID id) {
		super(x, y, id);

		
	
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
	
		x = Game.clamp(x, 0, Game.WIDTH-22);
		y = Game.clamp(y, 0, Game.HEIGHT-45);
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 16, 16);
	}

}
