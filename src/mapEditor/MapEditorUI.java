package mapEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gfx.Assets;
import tile.Tile;
import tilegame.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIObject;


public class MapEditorUI {
	
	private Handler handler;
	private UIObject[][] tileButtonArray;
	private static final int MAP_UI_WIDTH = 150;
	private static final int  MAP_UI_HEIGHT = 450;
	

	public MapEditorUI(Handler handler) {
		this.handler = handler;
		createTileButtonArray();
	}
	
	private void createTileButtonArray() {
		tileButtonArray = new UIObject[6][2];
		
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[0].length; j++) {
				tileButtonArray[i][j] = createTileButton(j*(Tile.TILEWIDTH + 4),i*(Tile.TILEHEIGHT + 4));
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(255, 255, 255, 50));
		g.fillRect(handler.getWidth()-MAP_UI_WIDTH-10, handler.getHeight()-MAP_UI_HEIGHT-10, MAP_UI_WIDTH, MAP_UI_HEIGHT);
		for(UIObject[] tileButtons : tileButtonArray) {
			for(UIObject tileButton : tileButtons) {
				tileButton.render(g);
			}
		}
	}
	
	private UIObject createTileButton(int distFromRectTopRightX, int distFromRectTopRightY) {
		return new UIImageButton((float)handler.getWidth() - MAP_UI_WIDTH - 2 + distFromRectTopRightX, 
				                 (float) handler.getHeight() - MAP_UI_HEIGHT - 2 + distFromRectTopRightY, 
				                 Tile.TILEWIDTH, Tile.TILEHEIGHT, 
				                 new BufferedImage[] {Assets.grass11,Assets.grass14}, 
				                 new ClickListener() {
			@Override
			public void onClick() {
				//TODO THIS ISN'T BEING CALLED BECAUSE OF THE UIMANAGER PROBLEMS :( THESE GUYS NEED TO GET
				// INTO THE UIMANAGER...
				System.out.println("tile button clicked");
				
			}
		});
	}
	
	
	
	
	

}
