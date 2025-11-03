package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Chest extends TileEntity{
    public Chest(GamePanel gp) {
        super(gp);
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/chest.png")));
        }catch(Exception ignored){}
    }
}
