package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = (gp.screenWidth - gp.tileSize)/2;
        screenY = (gp.screenHeight - gp.tileSize)/2;

        setDefaultValues();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize*22;
        worldY = gp.tileSize*22;
        speed = 6;
    }
    public void update(){
        worldY -= keyH.upPressed ? speed : 0;
        worldY += keyH.downPressed ? speed : 0;
        worldX -= keyH.leftPressed ? speed : 0;
        worldX += keyH.rightPressed ? speed : 0;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(screenX, screenY,gp.tileSize, gp.tileSize);
    }
}
