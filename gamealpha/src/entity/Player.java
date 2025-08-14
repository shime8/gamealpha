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
        ScreenX = 200;
        ScreenY = 200;
        EngineX = 0;
        EngineY = 0;
        speed = 4;
    }

    public void update(){
        EngineY -= keyH.upPressed ? speed : 0;
        EngineY += keyH.downPressed ? speed : 0;
        EngineX -= keyH.leftPressed ? speed : 0;
        EngineX += keyH.rightPressed ? speed : 0;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);

        g2.fillRect(ScreenX,ScreenY,gp.tileSize, gp.tileSize);
    }
}
