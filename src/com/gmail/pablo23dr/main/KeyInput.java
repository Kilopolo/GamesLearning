package com.gmail.pablo23dr.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler=handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int key = e.getKeyCode();
		//loops through all the objects in the game
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//Key Events for Player
			if (tempObject.getId()== ID.Player) {
				if (key== KeyEvent.VK_W) tempObject.setVelY(-5);
				if (key== KeyEvent.VK_S) tempObject.setVelY(5);
				if (key== KeyEvent.VK_D) tempObject.setVelX(5);
				if (key== KeyEvent.VK_A) tempObject.setVelX(-5);
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//Key Events for Player
			if (tempObject.getId()== ID.Player) {
				if (key== KeyEvent.VK_W) tempObject.setVelY(0);
				if (key== KeyEvent.VK_S) tempObject.setVelY(0);
				if (key== KeyEvent.VK_D) tempObject.setVelX(0);
				if (key== KeyEvent.VK_A) tempObject.setVelX(0);
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
		
		
	}

	
	
}
