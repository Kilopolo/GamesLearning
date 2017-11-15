package com.gmail.pablo23dr.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);

		velX = r.nextInt(5);
		velY = r.nextInt(5);

	}

	@Override
	public void tick() {

		if (y <= 0 || y >= Game.HEIGHT - 45)
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 22)
			velX *= -1;

		x += velX;
		y += velY;

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 16, 16);
	}
	
	public void checkCollision(boolean colision) {
		
//		if()
		

	}
}
