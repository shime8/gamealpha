package tile;

import main.GamePanel;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setTileEntity(){
        gp.te[0] = new Chest();
        gp.te[0].worldX = 7 * gp.tileSize;
        gp.te[0].worldY = 7 * gp.tileSize;

    }
}
