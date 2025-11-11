package UI;

import main.GamePanel;
import main.KeyHandler;
import mechanic.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InventoryUI extends BaseUI{
    public Inventory PlayerInventory;
    Color SecondColor = new Color(100,100,100);
    public InventoryUI(GamePanel gp, KeyHandler keyH, java.awt.Rectangle rect, Color BGColor, int size) {
        super(gp, keyH, rect, BGColor);
        PlayerInventory = new Inventory(size);
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        int margin = Rectangle.width/50;
        int slotsWidth = Rectangle.width-margin;
        int slotSizeWithSpace = slotsWidth/PlayerInventory.size;
        int slotSize = slotSizeWithSpace-margin;
        for(int i=0; i<PlayerInventory.size; i++){
            g2.setColor(SecondColor);
            g2.fillRect(Rectangle.x + margin + (margin+slotSize)*i, Rectangle.y + margin, slotSize, slotSize);
            if(PlayerInventory.Get(i)!=null && PlayerInventory.Get(i).image!=null) {
                g2.drawImage(PlayerInventory.Get(i).image, Rectangle.x + 2*margin + (margin + slotSize) * i, Rectangle.y + 2*margin, slotSize-2*margin, slotSize-2*margin, null);
            }
        }
    }
}
