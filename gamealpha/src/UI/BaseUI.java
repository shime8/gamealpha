package UI;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class BaseUI {
    GamePanel gp;
    KeyHandler keyH;
    Rectangle Rectangle;
    Color BGColor;


    public BaseUI(GamePanel gp, KeyHandler keyH,Rectangle rect, Color BGColor){
        this.gp = gp;
        this.keyH = keyH;
        this.Rectangle = rect;
        this.BGColor = BGColor;
    }
    public void draw(Graphics2D g2){
        g2.setColor(BGColor);
        g2.fillRect(Rectangle.x, Rectangle.y, Rectangle.width, Rectangle.height);
    }
}
