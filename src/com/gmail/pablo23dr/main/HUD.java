package com.gmail.pablo23dr.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH = 100;

	public void tick() {

		HEALTH--;
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 10);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 10);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 10);
	}

}
