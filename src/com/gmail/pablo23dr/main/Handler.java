package com.gmail.pablo23dr.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
/**
 * maintain or update and render all of our objects in our room
 * -you have your different objects right, since we'r gonna have more than one
 * object in the game we'r gonna need to handle and process each one of those objects,
 * it doesn't just happens automatically so this handler class is going to loop through 
 * all our objects in our game and individually update them and render them to the screen.
 *  
 *  */
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		/**
		 * recorre todos los objetos del juego <GameObject> 
		 * -inside we'r setting our temporary object to object.get(i);
		 */
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {

		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
			
		}
	}
	
	public void addObject (GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
