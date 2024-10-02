package TestConstants;

import Constants.FilesLocations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestConstants {
    public static BufferedImage expectedImage;

    static {
        try {
            expectedImage = ImageIO.read(new File(FilesLocations.CORRECT_RESULT_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
    public static int numberOfTries = 10;


}
