package computer_master_graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class loadImage {

    public static BufferedImage image;
    public static BufferedImage entities;
    public static BufferedImage player, enemy;

    public static void init() {
        try {
            //        image = imageLoader("/whte.png");
//        entities = imageLoader("/Assets/airplane.png");
//        crop();
            image = ImageIO.read(new File("Assets/whte.png"));
            entities = ImageIO.read(new File("Assets/entities.png"));
            crop();
        } catch (IOException ex) {}

    }

    public static BufferedImage imageLoader(String path) {
        try {
            return ImageIO.read(loadImage.class.getResource(path));
        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(1);
        }
        return null;
    }

    public static void crop() {
        enemy = entities.getSubimage(0, 0, 115, 95);
        player = entities.getSubimage(115, 0, 115, 95);
    }

}
