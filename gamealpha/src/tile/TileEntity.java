package tile;

import main.GamePanel;

import java.awt.*;

public class TileEntity extends Tile{

    GamePanel gp;
    public int TE_UID;
    public Rectangle solidArea;
    public int worldX, worldY;
    public TileEntity(GamePanel gp){
        this.gp = gp;

    }
    public void draw(Graphics2D g2){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
                worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
                worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
                worldY < gp.player.worldY + gp.player.screenY + gp.tileSize) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
