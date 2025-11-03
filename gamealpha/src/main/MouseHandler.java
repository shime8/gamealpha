package main;


import tile.Chest;
import tile.Tile;
import tile.TileEntity;
import tile.TileEntityManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
    int MscreenX, MscreenY, MworldX, MworldY, MscreenGridX, MscreenGridY, MworldGridX, MworldGridY;
    boolean rightButtonDown = false;
    boolean leftButtonDown = false;
    public enum MActionTypes {
        None,
        Place,
        Destroy
    }
    MActionTypes MAType = MActionTypes.None;
    BufferedImage image = null;
    GamePanel gp;
    TileEntity TileToPlace = null;
    public MouseHandler(GamePanel gp){
        this.gp = gp;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/chest.png")));
        }catch(Exception ignored){};
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            MAType = MActionTypes.Destroy;
            leftButtonDown = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) {
            MAType = MActionTypes.Place;
            TileToPlace = new Chest(gp);
            rightButtonDown = true;
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftButtonDown = false;
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            rightButtonDown = false;
        }
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

        if (leftButtonDown) {
            MAType = MActionTypes.Destroy;
        }
        else if (rightButtonDown) {
            MAType = MActionTypes.Place;
            TileToPlace = new Chest(gp);
        }
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();

        if (notches < 0) {
            //up
            gp.tileSize += e.getScrollAmount();
        } else {
            //down
            gp.tileSize -= e.getScrollAmount();
        }

        // e.getScrollAmount());
        //  e.getPreciseWheelRotation());
    }
    public void update(){
        MworldX = MscreenX + gp.player.worldX - gp.player.screenX;
        MworldY = MscreenY + gp.player.worldY - gp.player.screenY;
        MworldGridX = MworldX- MworldX%gp.tileSize;
        MworldGridY = MworldY- MworldY%gp.tileSize;
        MscreenGridX = MworldGridX - gp.player.worldX + gp.player.screenX;
        MscreenGridY = MworldGridY - gp.player.worldY + gp.player.screenY;
        switch(MAType){
            case None: break;
            case Place:
                if(TileToPlace != null){
                    TileToPlace.gridX = this.MworldGridX/gp.tileSize;
                    TileToPlace.gridY = this.MworldGridY/gp.tileSize;
                    gp.tileEntityM.addTile(TileToPlace.clone());
                    //TEmp = null;
                }
                break;
            case Destroy: gp.tileEntityM.destroyTile(this.MworldGridX/gp.tileSize,this.MworldGridY/gp.tileSize);break;
        }
        if(!leftButtonDown && !rightButtonDown){MAType = MActionTypes.None;}

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
