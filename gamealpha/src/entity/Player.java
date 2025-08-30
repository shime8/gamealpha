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
        direction.x = 0;
        direction.y = 0;
    }
    public void update(){

        // kierunek
        direction.x = 0;
        direction.y = 0;
        if(keyH.upPressed){
            direction.y -= 1.0;
        }
        if(keyH.downPressed){
            direction.y += 1.0;
        }
        if(keyH.leftPressed){
            direction.x -= 1.0;
        }
        if(keyH.rightPressed){
            direction.x += 1.0;
        }
        direction.setLengthOne();
        updateSteps();


        // sprawdzenie kolizji
        collisionYOn = false;
        collisionXOn = false;
        gp.cChecker.checkTile(this);

        //ruch gracza
        if(!collisionXOn){
            worldX += stepX;
        }
        if(!collisionYOn){
            worldY += stepY;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(screenX, screenY,gp.tileSize, gp.tileSize);
    }

}
