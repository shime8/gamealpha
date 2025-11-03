package tile;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class TileEntityManager {
    GamePanel gp;
    public ArrayList<TileEntity> teList;

    public TileEntityManager(GamePanel gp) {
        this.gp = gp;
        teList = new ArrayList<>();
    }

    public void draw(Graphics2D g2){
        if(teList != null) {
            for (TileEntity t : teList) {
                if (t != null) {
                    t.draw(g2);
                }
            }
        }
    }
    public void addTile(TileEntity te){
        boolean exists = false;

        for (TileEntity t : teList) {
            if (t.worldX == te.worldX && t.worldY == te.worldY) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            teList.add(te);
        }
    }
}
