package states;

import java.awt.Graphics;

import tilegame.Handler;


public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state){
		
		// TODO THIS IS A HACKY FIX BECAUSE UIBUTTONS AND CARRYING OVER TO GAMESTATE WHEN THEY SHOULDNT
		if(currentState instanceof MenuState && state instanceof GameState) {
			currentState.closeState();
		}
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();

	public abstract void render(Graphics g);
	
	public abstract void closeState();

}
