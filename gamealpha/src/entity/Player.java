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

        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        y -= keyH.upPressed ? speed : 0;
        y  += keyH.downPressed ? speed : 0;
        x  -= keyH.leftPressed ? speed : 0;
        x += keyH.rightPressed ? speed : 0;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x,y,gp.tileSize, gp.tileSize);
    }
}
