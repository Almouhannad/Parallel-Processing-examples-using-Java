package SlicesImageRecolorMethod;

import Abstractions.IImageRecolorMethod;
import Constants.FilesLocations;
import Helpers.ImageProcessingHelper;
import SlicesMethod.SlicesImageRecolorMethod;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestSlicesImageRecolorMethod extends TestCase {

    public void testSlicesImageRecolorMethodOutput() throws IOException {
        IImageRecolorMethod method = new SlicesImageRecolorMethod(1);
        method.recolorImage();

        BufferedImage expectedImage = null;
        expectedImage = ImageIO.read(new File(FilesLocations.CORRECT_RESULT_FILE));

        BufferedImage generatedImage = null;
        generatedImage = ImageIO.read(new File(FilesLocations.DESTINATION_FILE));

        Assert.assertTrue(ImageProcessingHelper.areImagesEqual(expectedImage, generatedImage));
    }

    public void testSlicesImageRecolorMethodOutputMultithreaded() throws IOException {
        IImageRecolorMethod method = new SlicesImageRecolorMethod(10);
        method.recolorImage();

        BufferedImage expectedImage = null;
        expectedImage = ImageIO.read(new File(FilesLocations.CORRECT_RESULT_FILE));

        BufferedImage generatedImage = null;
        generatedImage = ImageIO.read(new File(FilesLocations.DESTINATION_FILE));

        Assert.assertTrue(ImageProcessingHelper.areImagesEqual(expectedImage, generatedImage));
    }


    public void testSlicesImageRecolorMethodPerformance() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int numRuns = 10;

        for (int threads : threadCounts) {
            System.out.println("Threads: " + threads);
            long totalTime = 0;
            for (int i = 0; i < numRuns; i++) {
                IImageRecolorMethod method = new SlicesImageRecolorMethod(threads);
                long start = System.currentTimeMillis();
                method.recolorImage();
                long end = System.currentTimeMillis();
                long time = (end - start);
                totalTime += time;
            }
            long averageTime = totalTime / numRuns;
            System.out.println("  Average Time: " + averageTime + "ms");
        }
    }
}

