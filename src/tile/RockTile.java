package tile;

import gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override //As rock is solid, we override the default method from the Tile class
	public boolean isSolid(){
		return true;
	}

}
