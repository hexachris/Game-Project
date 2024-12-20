package main;

import object.OBJ_Chest; 
import object.OBJ_Door;
import object.OBJ_FastBoots;
import object.OBJ_Leaves;

public class AssetSetter {
	
	GamePanel gp; 
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Leaves();
		gp.obj[0].worldX = 23 * gp.TileSize;
		gp.obj[0].worldY = 7 * gp.TileSize;
		
		gp.obj[1] = new OBJ_Leaves();
		gp.obj[1].worldX = 23 * gp.TileSize;
		gp.obj[1].worldY = 40 * gp.TileSize;
		
		gp.obj[2] = new OBJ_Leaves();
		gp.obj[2].worldX = 64 * gp.TileSize;
		gp.obj[2].worldY = 66 * gp.TileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 28 * gp.TileSize;
		gp.obj[3].worldY = 18 * gp.TileSize;
		
		gp.obj[4] = new OBJ_Chest();
		gp.obj[4].worldX = 24 * gp.TileSize;
		gp.obj[4].worldY = 14 * gp.TileSize;
		
		gp.obj[5] = new OBJ_FastBoots();
		gp.obj[5].worldX = 15 * gp.TileSize;
		gp.obj[5].worldY = 9 * gp.TileSize;
		
		gp.obj[6] = new OBJ_Door();
		gp.obj[6].worldX = 50 * gp.TileSize;
		gp.obj[6].worldY = 26  * gp.TileSize;
	}
	
}
