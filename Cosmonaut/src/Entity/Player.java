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

    public Player (GamePanel gp, KeyInputs keyInputs) {

        this.gp = gp;
        this.keyInputs = keyInputs;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "Down";
    }
    public void getPlayerImage(){
        try {
        
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Up_2.png"));
            Down1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Down_1.png"));
            Down2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Down_2.png"));
            Left1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Left_1.png"));
            Left2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Left_2.png"));
            Right1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Right_1.png"));
            Right2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player_Right_2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    public void update(){

        if (keyInputs.UpPressed == true){
            direction = "up";
            y -= speed;
        }
        else if (keyInputs.DownPressed == true){
            direction = "Down";
            y += speed;
        }
        else if (keyInputs.LeftPressed == true){
            direction = "Left";
            x -= speed;
        }
        else if (keyInputs.RightPressed == true){
            direction = "Right";
            x += speed;
        }
    }
    public void Draw(Graphics2D g2){
        
        BufferedImage image = null;

        switch (direction) {
        case "up":
            image = up1;
            break;
        case "Down":
            image = Down1;
            break;
        case "Left":
            image = Left1;
            break;
        case "Right":
            image = Right1;
            break;
        }
        g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
}
