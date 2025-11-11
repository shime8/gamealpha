package items;

import java.awt.image.BufferedImage;

public class Item {
    // to do: public TYPE
    public BufferedImage image;
    public int amount;

    public Item(BufferedImage image, int amount){
        this.image = image;
        this.amount = amount;
    }
}
