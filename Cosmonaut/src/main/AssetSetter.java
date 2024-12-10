package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_souvenir;

public class AssetSetter {
	
	GamePanel gp; 
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_souvenir();
		gp.obj[0].worldX = 23 * gp.TileSize;
		gp.obj[0].worldY = 7 * gp.TileSize;
		
		gp.obj[1] = new OBJ_souvenir();
		gp.obj[1].worldX = 23 * gp.TileSize;
		gp.obj[1].worldY = 40 * gp.TileSize;
		
		gp.obj[2] = new OBJ_souvenir();
		gp.obj[2].worldX = 37 * gp.TileSize;
		gp.obj[2].worldY = 7 * gp.TileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 10 * gp.TileSize;
		gp.obj[3].worldY = 11 * gp.TileSize;
		
		gp.obj[4] = new OBJ_Chest();
		gp.obj[4].worldX = 10 * gp.TileSize;
		gp.obj[4].worldY = 7 * gp.TileSize;
	}
	
}
