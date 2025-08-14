package Map;

import java.awt.*;
import java.util.Random;

public class GridLayer {
    public int width, height;
    public Tile[][] TileGrid;

    public GridLayer(int x, int y){
        width = x;
        height = y;
        TileGrid = new Tile[width][height];
    }

    public void randomize(){
        Random rand = new Random();
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                TileGrid[w][h] = new Tile(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
            }
        }
    }

    public void draw(Graphics2D g2, int x, int y, int tileSize){
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                TileGrid[w][h].draw(g2, x+tileSize*w, y+tileSize*h, tileSize);
            }
        }
    }
}
