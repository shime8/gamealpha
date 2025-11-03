package tile;

import main.GamePanel;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setTileEntity(){
        TileEntity TEmp = new Chest(gp);
        TEmp.worldX = 7* gp.tileSize;
        TEmp.worldY = 7* gp.tileSize;
        gp.tileEntityM.teList.add(TEmp);
    }
}
