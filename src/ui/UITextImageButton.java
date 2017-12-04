package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gfx.Assets;
import gfx.Text;

public class UITextImageButton extends UIImageButton{
	
	String textString;
	Boolean clicking = false;

	public UITextImageButton(float x, float y, int width, int height, BufferedImage[] images, String textString, ClickListener clicker) {
		super(x, y, width, height, images, clicker);
		this.textString = textString;
	}

	
	@Override
	public void render(Graphics g) {
		if(clicking)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		
		if(hovering)
			Text.drawString(g, textString, (int)x + width/2, (int)y + height/2, true, Color.WHITE, Assets.garamond28);
		else
			Text.drawString(g, textString, (int)x + width/2, (int)y + height/2, true, Color.BLACK, Assets.garamond28);
		
	}
	
	@Override
	public void onMousePressed(MouseEvent e) {
		if(hovering == true) {
			clicking = true;
		}
	}


	@Override
	public void onMouseRelease(MouseEvent e) {
		super.onMouseRelease(e);
		clicking = false;
	}
	
	
	
}
