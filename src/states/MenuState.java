package states;

import java.awt.Graphics;

import gfx.Assets;
import gfx.Background;
import tilegame.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;
import ui.UITextImageButton;

public class MenuState extends State {

	private UIManager uiManager;
	private Background background;
	private static final int BUTTON_HEIGHT = 64;
	private static final int BUTTON_WIDTH = 128;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		background = new Background(Assets.menuBackground, Assets.menuBackground.getWidth(), Assets.menuBackground.getHeight());

		uiManager.addObject(new UITextImageButton(handler.getWidth()/2 - BUTTON_WIDTH/2, BUTTON_WIDTH, BUTTON_WIDTH, BUTTON_HEIGHT, Assets.btn_start, "Start", new ClickListener() {
					@Override
					public void onClick() {
						State.setState(handler.getGame().gameState);
						
					}
				}));
		
		uiManager.addObject(new UITextImageButton(handler.getWidth()/2 - BUTTON_WIDTH/2, BUTTON_WIDTH + BUTTON_HEIGHT + 4, BUTTON_WIDTH, BUTTON_HEIGHT, Assets.btn_start, "Settings", new ClickListener() {
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UITextImageButton(handler.getWidth()/2 - BUTTON_WIDTH/2, BUTTON_WIDTH + 2*(BUTTON_HEIGHT + 4), BUTTON_WIDTH , BUTTON_HEIGHT, Assets.btn_start, "Settings",new ClickListener() {
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UITextImageButton(handler.getWidth()/2 - BUTTON_WIDTH/2, BUTTON_WIDTH + 3*(BUTTON_HEIGHT + 4), BUTTON_WIDTH, BUTTON_HEIGHT, Assets.btn_start,"Settings", new ClickListener() {
			@Override
			public void onClick() {
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		uiManager.render(g);
		
	}
}
