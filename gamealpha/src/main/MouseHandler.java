package main;


import tile.Chest;
import tile.Tile;
import tile.TileEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MouseHandler implements MouseListener, MouseMotionListener {
    int MscreenX, MscreenY, MworldX, MworldY, MscreenGridX, MscreenGridY, MworldGridX, MworldGridY;
    BufferedImage image = null;
    GamePanel gp;
    TileEntity TEmp = null;
    public MouseHandler(GamePanel gp){
        this.gp = gp;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/chest.png")));
        }catch(Exception ignored){};
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1) {


        }
        if(e.getButton() == 2) {

        }

        TEmp = new Chest(gp);

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        MscreenX = e.getX();
        MscreenY = e.getY();


    }
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
        mouseClicked(e);
    }
    public void update(){
        MworldX = MscreenX + gp.player.worldX - gp.player.screenX;
        MworldY = MscreenY + gp.player.worldY - gp.player.screenY;
        MworldGridX = MworldX- MworldX%gp.tileSize;
        MworldGridY = MworldY- MworldY%gp.tileSize;
        MscreenGridX = MworldGridX - gp.player.worldX + gp.player.screenX;
        MscreenGridY = MworldGridY - gp.player.worldY + gp.player.screenY;
        if(TEmp != null){
            TEmp.worldX = this.MworldGridX;
            TEmp.worldY = this.MworldGridY;
            gp.tileEntityM.addTile(TEmp);
            TEmp = null;
        }
    }
    public void draw(Graphics2D g2){

        if(MscreenX != 0 && MscreenY != 0) {

            Graphics2D g2d = (Graphics2D) g2.create();
            float opacity = 0.5f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            g2d.drawImage(image, MscreenGridX, MscreenGridY, gp.tileSize, gp.tileSize, null);
            g2d.dispose();
        }
    }
}
