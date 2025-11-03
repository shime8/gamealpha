package tile;

import main.GamePanel;

import java.awt.*;

public class TileEntity extends Tile implements Cloneable{

    GamePanel gp;
    public int TE_UID;
    public Rectangle solidArea;
    public int gridX, gridY;
    public TileEntity(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        int worldX = gridX * gp.tileSize;
        int worldY = gridY * gp.tileSize;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
                worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
                worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
                worldY < gp.player.worldY + gp.player.screenY + gp.tileSize) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    @Override
    public TileEntity clone() {
        try {
            TileEntity copy = (TileEntity) super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed", e);
        }
    }
}
