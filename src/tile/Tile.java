package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gfx.Assets;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(1);
	
	public static Tile rockTile2 = new RockTile(2, Assets.stone2);
	public static Tile rockTile3 = new RockTile(3, Assets.stone3);
	public static Tile rockTile4 = new RockTile(4, Assets.stone4);
	public static Tile rockTile5 = new RockTile(5, Assets.stone5);
	
	public static Tile grassTile = new GrassTile(0, Assets.grass);
	public static Tile grassTile11 = new GrassTile(11, Assets.grass11);
	public static Tile grassTile12 = new GrassTile(12, Assets.grass12);
	public static Tile grassTile13 = new GrassTile(13, Assets.grass13);
	public static Tile grassTile14 = new GrassTile(14, Assets.grass14);
	
	
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
