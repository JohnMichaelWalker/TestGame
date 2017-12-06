package states;

import java.awt.Graphics;

import tilegame.Handler;
import worlds.World;

public class GameState extends State {
	
	private World world;

	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	public void tick() {
		world.tick();
	}

	public void render(Graphics g) {
		world.render(g);
	}

	@Override
	public void closeState() {
		// TODO Auto-generated method stub
		
	}
	
}
