package Map;

import java.awt.*;

public class Tile {
    public Color bgcolor;
    public Tile(Color bgcolor){
        this.bgcolor = bgcolor;
    }

    public void draw(Graphics2D g2, int x, int y, int tileSize){
        g2.setColor(bgcolor);
        g2.fillRect(x,y,tileSize, tileSize);
    }
}
