package tile;

import main.GamePanel;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setTileEntity(){
        TileEntity TEmp = new Chest(gp);
        TEmp.gridX = 7;
        TEmp.gridY = 7;
        gp.tileEntityM.teList.add(TEmp);
    }
}
