package entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.Entity;
import gfx.Animation;
import gfx.Assets;
import inventory.Inventory;
import tilegame.Handler;
import worldEditter.MapEditor;

public class Player extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	private char currentDirection; //U,D,L,R
	
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	private Inventory inventory;
	
	private MapEditor mapEditor;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH,
				Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;

		// Animations
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
		currentDirection = 'D';
		
		inventory = new Inventory(handler);
		mapEditor = new MapEditor(handler);
	}

	public void tick() {
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getInput(); // Sets xMove and yMove to 0 unless a key is pressed
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		//MapEditor
		mapEditor.tick();
		//Inventory
		inventory.tick();
	}
	
	public void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer =  System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		if(inventory.isActive())
			return;
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width/2 - arSize/2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width/2 - arSize/2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height/2 - arSize/2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height/2 - arSize/2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
	}
	
	public void die(){
		System.out.println("You lose...");
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(inventory.isActive())
			return;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera()
				.getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
				width, height, null);
	}
	
	public void postRender(Graphics g){
		inventory.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if (xMove < 0){
			currentDirection = 'L';
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			currentDirection = 'R';
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			currentDirection = 'U';
			return animUp.getCurrentFrame();
		}else if (yMove > 0){
			currentDirection = 'D';
			return animDown.getCurrentFrame();
		} else {
			switch (currentDirection) {
			case 'L':
				return Assets.player_left[0];
			case 'R':
				return Assets.player_right[0];
			case 'U':
				return Assets.player_up[0];
			case 'D':
				return Assets.player_down[0];
			default:
				System.err.println("Player animation was not set properly");
				return Assets.player_left[0];
			} 
		}
	}
	
	//Getters and Setters

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	
}




