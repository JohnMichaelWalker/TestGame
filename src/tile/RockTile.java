package tile;

import java.awt.image.BufferedImage;

public class RockTile extends Tile{

	public RockTile(int id, BufferedImage image) {
		super(image, id);
	}
	
	@Override //As rock is solid, we override the default method from the Tile class
	public boolean isSolid(){
		return true;
	}

}
