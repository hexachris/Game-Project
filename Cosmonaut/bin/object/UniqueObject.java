package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class UniqueObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int ScreenX = worldX - gp.player.worldX + gp.player.ScreenX;
		int ScreenY = worldY - gp.player.worldY + gp.player.ScreenY;
		
		if(worldX + gp.TileSize > gp.player.worldX - gp.player.ScreenX &&
		   worldX - gp.TileSize < gp.player.worldX + gp.player.ScreenX &&
		   worldY + gp.TileSize > gp.player.worldY - gp.player.ScreenY &&
		   worldY - gp.TileSize< gp.player.worldY + gp.player.ScreenY) {
			
			g2.drawImage(image, ScreenX, ScreenY, gp.TileSize, gp.TileSize,null );
		}
		
	}

}
