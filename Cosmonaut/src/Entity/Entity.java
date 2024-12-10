package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	public BufferedImage Up1, Up2, Down1,Down2,Left1,Left2,Right1,Right2;
	public String direction;
	public int SpriteCounter = 0;
	public int SpriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
}
