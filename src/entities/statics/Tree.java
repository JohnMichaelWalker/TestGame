package entities.statics;

import java.awt.Graphics;

import gfx.Assets;
import items.Item;
import tile.Tile;
import tilegame.Handler;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		bounds.x = 20;
		bounds.y = 110;
		bounds.width = width - 40;
		bounds.height = 10;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
