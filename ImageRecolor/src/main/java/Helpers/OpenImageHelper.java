package Helpers;

import Constants.FilesLocations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenImageHelper {
    public static BufferedImage openImage() throws IOException {
        return ImageIO.read(new File(FilesLocations.SOURCE_FILE));
    }
}
