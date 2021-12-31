package cs.vsu.ru.kapustin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    public static void printImageToFile(File file, BufferedImage image) throws IOException {
        ImageIO.write(image, "jpg", file);
    }
}
