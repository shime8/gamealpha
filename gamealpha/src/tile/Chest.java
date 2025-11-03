package tile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Chest extends TileEntity{
    public Chest() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/chest.png")));
        }catch(Exception ignored){}
    }
}
