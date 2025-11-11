package entity;

import main.GamePanel;
import main.Vector2D;

import java.awt.*;

public class Entity {
    GamePanel gp;

    public int worldX, worldY;
    public int screenX, screenY;
    public int speed;
    public Vector2D direction = new Vector2D(0,0);
    public int stepX, stepY;
    public Rectangle solidArea;
    public boolean collisionYOn = false, collisionXOn = false ;

    public void updateSteps(){
        this.stepX = (int) ((double)speed*direction.x);
        this.stepY = (int) ((double)speed*direction.y);
    }
    public void drawHitbox(Graphics2D g2){
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x,screenY + solidArea.y,solidArea.width,solidArea.height);
    }

}
