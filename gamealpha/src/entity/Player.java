package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;



    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = (gp.screenWidth - gp.tileSize)/2;
        screenY = (gp.screenHeight - gp.tileSize)/2;

        solidArea = new Rectangle();
        solidArea.x = gp.tileSize/4;
        solidArea.y = gp.tileSize/4;
        solidArea.width = gp.tileSize/2;
        solidArea.height = 2*gp.tileSize/3;

        setDefaultValues();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize*22;
        worldY = gp.tileSize*22;
        speed = 6;
        direction ="down";
    }
    public void update(){

        // kierunek
        if(keyH.upPressed){
            direction = "up";
        }
        if(keyH.downPressed){
            direction = "down";
        }
        if(keyH.leftPressed){
            direction = "left";
        }
        if(keyH.rightPressed){
            direction = "right";
        }

        // sprawdzenie kolizji
        collisionYOn = false;
        collisionXOn = false;
        gp.cChecker.checkTile(this);

        //ruch gracza
        if(!collisionXOn){switch (direction){
            case "left":    if(keyH.leftPressed)worldX -= speed;break;
            case "right":   if(keyH.rightPressed)worldX += speed;break;
        }}
        if(!collisionYOn){switch(direction){
            case "up":      if(keyH.upPressed)worldY -= speed;break;
            case "down":    if(keyH.downPressed)worldY += speed;break;
        }}
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(screenX, screenY,gp.tileSize, gp.tileSize);
    }

}
