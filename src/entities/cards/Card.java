package entities.cards;

import java.awt.Graphics;

import entities.Entity;
import gfx.Assets;
import tilegame.Handler;

public class Card extends Entity{

	public Card(Handler handler, float x, float y) {
		super(handler, x, y, 335/2, 515/2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.testCard1, (int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), 335/2, 515/2, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
