package tilegame;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import input.KeyManager;
import input.MouseManager;
import states.GameState;
import states.MenuState;
import states.SettingsState;
import states.State;

/*
 * GAME LOOP (SEE METHOD 'RUN'):
 * 1. UPDATE ALL VARIABLES, POSITIONS OF OBJECTS, ETC.
 * 2. RENDER (DRAW) EVERYTHING TO THE SCREEN
 * 3. REPEAT INDEFINITELY
 */

public class Game implements Runnable { // Runnable allows it to be run on a
										// thread
	private Display display;
	private int width, height; // Store public dimensions integers
	public String title; // Store public title variable

	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;

	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		State.setState(menuState);
	}

	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
		
		//TESTING!////////////DELETE ME
		
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){ //If there is no buffer strategy, create one
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); //Graphics object allows us to draw to the canvas (like a magic paintbrush)
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here!//////////////////////////////////////
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!/////////////////////////////////////
		
		bs.show(); // "works the buffer magic"
		g.dispose(); // 
	}

	public void run() {
		
		init(); // Calls init method to initialise display + images
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while (running) { // While running is true keep ticking + rendering
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick; // Keeps adding on the time difference between loops
			lastTime = now;
			
			if(delta >= 1){ // As soon as delta hits 1 (timePerTick nanosecs have passed) we reset delta and "tick"
				tick();
				render();
				delta--; //-1 from delta (do not reduce to 0 as there will be a slight bit of time left over)
			}
			
		}

		stop(); // If running stops, then call the stop method to stop
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public synchronized void start() {

		if (running) // If code is already running, just keep running, don't run
						// this code
			return;
		running = true;
		thread = new Thread(this); // Run 'this' class on a new thread
		thread.start(); // This will call the 'run' method
	}

	public synchronized void stop() {
		if (!running) // If already stopped, don't try to stop again
			return;
		running = false; // Stop running
		try {
			thread.join(); // Closes the thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
