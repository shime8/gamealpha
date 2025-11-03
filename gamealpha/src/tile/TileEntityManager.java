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
            if (t.gridX == te.gridX && t.gridY == te.gridY) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            teList.add(te);
        }
    }
    public void destroyTile(int gridX, int gridY){
        boolean exists = false;
        TileEntity temp = null;
        for (TileEntity t : teList) {
            if (t.gridX == gridX && t.gridY == gridY) {
                exists = true;
                temp = t;
                break;
            }
        }
        if (exists) {
            teList.remove(temp);
        }
    }
}
