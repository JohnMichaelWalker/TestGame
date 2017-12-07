package mapEditor;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import input.MouseManager;
import tile.Tile;
import tilegame.Handler;

public class MapEditor {
	
	private Handler handler;
	private boolean active = false; //This should get toggled by the key, nothing is done if false
	private MouseManager mouseManager;
	private MapEditorUI mapEditorUI;
	
	
	public MapEditor(Handler handler){
		this.handler = handler;
		mouseManager = handler.getMouseManager();
		mapEditorUI = new MapEditorUI(handler);
	}

	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_M))
			active = !active;
		if(!active)
			return;
		
		if (mouseManager.isLeftPressed()){
			setTileAtMousePosition();
		}
	}
	
	public void render(Graphics g) {
		if(!active)
			return;
		
		mapEditorUI.render(g);
		
	}
	
	
	private void setTileAtMousePosition() {
		handler.getWorld().setTile((int)(mouseManager.getMouseX() + handler.getGameCamera().getxOffset())/Tile.TILEWIDTH, 
				                   (int)(mouseManager.getMouseY() + handler.getGameCamera().getyOffset())/Tile.TILEHEIGHT, 
								   Tile.grassTile11);
		
	}
	
	
	
	//GETTERS AND SETTERS

	public boolean isActive() {
		return active;
	}
}
