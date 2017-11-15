package com.gmail.pablo23dr.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -319931743351516544L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private HUD hud;

	public static void main(String[] args) {
		new Game();

	}

	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Game", this);

		hud=new HUD();
		
		r = new Random();

		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));

		handler.addObject(new BasicEnemy(r.nextInt(WIDTH / 2 - 32), r.nextInt(HEIGHT / 2 - 32), ID.BasicEnemy));

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int clamp(int var, int min, int max) {

		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else
			return var;
	}

	private void tick() {
		// ----------------------------------------------
		
		handler.tick();
		
		hud.tick();
		
		// ----------------------------------------------
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics gfx = bs.getDrawGraphics();

		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		// ----------------------------------------------
		
		handler.render(gfx);
		
		hud.render(gfx);
		
		// ----------------------------------------------
		gfx.dispose();
		bs.show();

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 1.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS" + frames);
				frames = 0;
			}
		}
		stop();

	}

}
