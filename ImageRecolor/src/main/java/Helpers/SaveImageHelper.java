package Helpers;

import Constants.FilesLocations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveImageHelper {
    public static void saveImage(BufferedImage resultImage) {
        String destinationFile = FilesLocations.DESTINATION_FILE;
        File outputFile = new File(destinationFile);
        try {
            ImageIO.write(resultImage, "jpg", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
