package entities.statics;

import java.awt.Graphics;

import gfx.Assets;
import items.Item;
import tile.Tile;
import tilegame.Handler;

public class Rock extends StaticEntity{
	
	public Rock(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 10;
		bounds.y = (int)(height / 2f);
		bounds.width = width - 20;
		bounds.height = (int) (height - 2*height / 3f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x, (int)y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	
	

}
