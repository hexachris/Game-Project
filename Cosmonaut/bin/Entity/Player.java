package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	public int Fragkey = 0;
	int StandCounter = 0;

	public Player(GamePanel gp, KeyInputs keyInputs) {
		
		this.gp = gp;
		this.keyInputs = keyInputs;
	
		ScreenX = gp.ScreenWidth/2 - (gp.TileSize/2);
		ScreenY = gp.ScreenHeight/2 - (gp.TileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValue();
		GetPlayerImage();
	}
	public void setDefaultValue() {
		
		worldX = gp.TileSize * 76;
		worldY = gp.TileSize * 88;
		speed = 4;
		direction = "Down";
	}
	public void GetPlayerImage() {
		
		try {
			
			Up1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_UP_1.png"));
			Up2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_UP_2.png"));
			Down1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Down_1.png"));
			Down2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Down_2.png"));
			Left1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Left_1.png"));
			Left2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Left_2.png"));
			Right1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Right_1.png"));
			Right2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		if (keyInputs.UpPressed == true || keyInputs.DownPressed == true || 
				keyInputs.LeftPressed == true || keyInputs.RightPressed == true) {
			

			if (keyInputs.UpPressed == true) {
				direction = "Up";
			}
			else if (keyInputs.DownPressed == true) {
				direction = "Down";
			}
			else if (keyInputs.LeftPressed == true) {
				direction = "Left";
			}
			else if (keyInputs.RightPressed == true) {
				direction = "Right";
			}
			
			//check tile collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//check object collision
			int objIndex = gp.cChecker.checkObject(this,  true);
			pickUpObject(objIndex);
			
			//if collision is false, player can move
			if (collisionOn == false) {
				
				switch(direction) {
				case "Up": worldY -= speed; break;
				case "Down": worldY += speed; break;
				case "Left": worldX -= speed; break;
				case "Right": worldX += speed; break;
				}
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
		else {
			StandCounter++;
			
			if(StandCounter == 20){
				SpriteNum = 1;
				StandCounter = 0;
			}
			
		}
		
	}
	public void pickUpObject(int i) {
		
		if (i != 999) {
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Leaves":
				gp.playSE(1);
				Fragkey++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got a Leaves!");
				break;
			case "Door":
				if(Fragkey > 0 ) {
					gp.playSE(3);
					gp.obj[i] = null;
					Fragkey--;
					gp.ui.showMessage("You opened the door!");
				}
				else {
					gp.ui.showMessage("You need a Leaves!");
				}
				System.out.println("Leaves:" + Fragkey);
				break;
			case "FastBoots":
				gp.playSE(2);
				speed += 2;
				gp.obj[i] = null;
				gp.ui.showMessage("Speed up!");
				break;
			case "Chest" :
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
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










