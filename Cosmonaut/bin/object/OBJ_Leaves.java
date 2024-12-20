package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Leaves extends UniqueObject {

	
	public OBJ_Leaves() {
		
		name = "Leaves";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Leaf.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
