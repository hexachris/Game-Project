package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_FastBoots extends UniqueObject{
	
	public OBJ_FastBoots( ) {
		
		name = "FastBoots";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/FastBoots.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
