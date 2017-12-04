package tilegame;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Tile Game!", 1024, 768); //640 480
		game.start();
	}
}
