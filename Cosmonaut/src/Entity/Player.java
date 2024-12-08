package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyInputs;

public class Player extends Entity{
	
	GamePanel gp;
	KeyInputs keyInputs;
	
	public final int ScreenX;
	public final int ScreenY;

	public Player(GamePanel gp, KeyInputs keyInputs) {
		
		this.gp = gp;
		this.keyInputs = keyInputs;
	
		ScreenX = gp.ScreenWidth/2 - (gp.TileSize/2);
		ScreenY = gp.ScreenHeight/2 - (gp.TileSize/2);
		
		setDefaultValue();
		GetPlayerImage();
	}
	public void setDefaultValue() {
		
		worldX = gp.TileSize * 23;
		worldY = gp.TileSize * 21;
		speed = 4;
		direction = "Down";
	}
	public void GetPlayerImage() {
		
		try {
			
			Up1 = ImageIO.read(getClass().getResource("/Player/Player_Up_1.png"));
			Up2 = ImageIO.read(getClass().getResource("/Player/Player_Up_2.png"));
			Down1 = ImageIO.read(getClass().getResource("/Player/Player_Down_1.png"));
			Down2 = ImageIO.read(getClass().getResource("/Player/Player_Down_2.png"));
			Left1 = ImageIO.read(getClass().getResource("/Player/Player_Left_1.png"));
			Left2 = ImageIO.read(getClass().getResource("/Player/Player_Left_2.png"));
			Right1 = ImageIO.read(getClass().getResource("/Player/Player_Right_1.png"));
			Right2 = ImageIO.read(getClass().getResource("/Player/Player_Right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		if (keyInputs.UpPressed == true || keyInputs.DownPressed == true || 
				keyInputs.LeftPressed == true || keyInputs.RightPressed == true) {
			

			if (keyInputs.UpPressed == true) {
				direction = "Up";
				worldY -= speed;
			}
			else if (keyInputs.DownPressed == true) {
				direction = "Down";
				worldY += speed;
			}
			else if (keyInputs.LeftPressed == true) {
				direction = "Left";
				worldX -= speed;
			}
			else if (keyInputs.RightPressed == true) {
				direction = "Right";
				worldX += speed;
			}
			
			SpriteCounter++;
			if (SpriteCounter > 12) {
				if (SpriteNum == 1) {
					SpriteNum = 2;
				}
				else if (SpriteNum == 2) {
					SpriteNum = 1;
				}
				SpriteCounter = 0;
			}
		}
		
	}
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch (direction) {
			
		case "Up":
			if(SpriteNum == 1) {
				image = Up1;
			}
			if(SpriteNum == 2) {
				image = Up2;
			}
			break;
		case "Down":
			if(SpriteNum == 1) {
				image = Down1;
			}
			if(SpriteNum == 2) {
				image = Down2;
			}
			break;
		case "Left":
			if(SpriteNum == 1) {
				image = Left1;
			}
			if(SpriteNum == 2) {
				image = Left2;
			}
			break;
		case "Right":
			if(SpriteNum == 1) {
				image = Right1;
			}
			if(SpriteNum == 2) {
				image = Right2;
			}
			break;
		}
		g2.drawImage(image,ScreenX, ScreenY, gp.TileSize, gp.TileSize, null);
	}
}










