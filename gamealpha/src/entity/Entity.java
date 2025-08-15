package entity;

import java.awt.*;

public class Entity {
    public int worldX, worldY;
    public int screenX, screenY;
    public int speed;
    public String direction;
    public Rectangle solidArea;
    public boolean collisionYOn = false, collisionXOn = false ;

    public void drawHitbox(Graphics2D g2){
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x,screenY + solidArea.y,solidArea.width,solidArea.height);
    }
}
