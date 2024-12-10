package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_souvenir extends UniqueObject{
	
	public OBJ_souvenir() {
		
		name = "Souvenir";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/souvenir.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
