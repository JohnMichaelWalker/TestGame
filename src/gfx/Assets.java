package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	public static Font garamond28;

	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	public static BufferedImage menuBackground;
	public static BufferedImage testCard1;
	
	//town1 stuff
	public static BufferedImage grass11, grass12, grass13, grass14;
	public static BufferedImage stone2, stone3, stone4, stone5;
	
	
	public static void init(){
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
		garamond28 = new Font ("Ariel", Font.PLAIN , 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet3.png"));
		SpriteSheet cardSheet = new SpriteSheet(ImageLoader.loadImage("/textures/cardsTest.png"));
		
		menuBackground = ImageLoader.loadImage("/textures/menuBackground1.png");
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		wood = sheet.crop(width, height*2, width, height);
		rock = sheet.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 3, width * 2, height);
		btn_start[1] = sheet.crop(width * 4, height * 3, width * 2, height);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		
		player_down[0] = sheet.crop(width*4, 0, width, height);
		player_down[1] = sheet.crop(width*4, height*2, width, height);
		player_down[2] = sheet.crop(width*5, 0, width, height);
		player_down[3] = sheet.crop(width*4, height*2, width, height);
		player_up[0] = sheet.crop(width*6, 0, width, height);
		player_up[1] = sheet.crop(width*5, height*2, width, height);
		player_up[2] = sheet.crop(width*7, 0, width, height);
		player_up[3] = sheet.crop(width*5, height*2, width, height);
		player_right[0] = sheet.crop(width*4, height, width, height);
		player_right[1] = sheet.crop(width*6, height*2, width, height);
		player_right[2] = sheet.crop(width*5, height, width, height);
		player_right[3] = sheet.crop(width*6, height*2, width, height);
		player_left[0] = sheet.crop(width*6, height, width, height);
		player_left[1] = sheet.crop(width*7, height*2, width, height);
		player_left[2] = sheet.crop(width*7, height, width, height);
		player_left[3] = sheet.crop(width*7, height*2, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		//grass = sheet.crop(width*2,0,width,height);
		//stone = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, height, width, height * 2);
		
		testCard1 = cardSheet.crop(0, 0, 335, 515);
		
		SpriteSheet town1Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/town01.png"));
		
		grass = town1Sheet.crop(0, 0, width, height);
		stone2 = town1Sheet.crop(width*2, 0, width, height);
		stone3 = town1Sheet.crop(width*3, 0, width, height);
		stone4 = town1Sheet.crop(width*6, 0, width, height);
		stone5 = town1Sheet.crop(width*7, 0, width, height);
		
		grass11 = town1Sheet.crop(width*6, height*3, width, height);
		grass12 = town1Sheet.crop(0, 0, width, height);
		grass13 = town1Sheet.crop(0, 0, width, height);
		grass14 = town1Sheet.crop(0, 0, width, height);
		
		
		
		
		
		
		
		
		
		
		
	}
}
