package SlicesImageRecolorMethod;

import Abstractions.ImageRecolorMethod;
import Constants.FilesLocations;
import Helpers.ImageProcessingHelper;
import SlicesMethod.SlicesImageRecolorMethod;
import TestConstants.TestConstants;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestSlicesImageRecolorMethod extends TestCase {

    private void outputTestHelper (int threadsCount) throws IOException {
        ImageRecolorMethod method = new SlicesImageRecolorMethod(threadsCount);
        method.recolorImage();
        method.saveImage();

        BufferedImage generatedImage = ImageIO.read(new File(FilesLocations.DESTINATION_FILE));

        Assert.assertTrue(ImageProcessingHelper.areImagesEqual(generatedImage, TestConstants.expectedImage));
    }

    private void performanceTestHelper() {
        for (int threads : TestConstants.threadCounts) {
            System.out.println("Threads: " + threads);
            long totalTime = 0;
            for (int i = 0; i < TestConstants.numberOfTries; i++) {
                ImageRecolorMethod method = new SlicesImageRecolorMethod(threads);
                long start = System.currentTimeMillis();
                method.recolorImage();
                long end = System.currentTimeMillis();
                long time = (end - start);
                totalTime += time;
            }
            long averageTime = totalTime / TestConstants.numberOfTries;
            System.out.println("  Average Time: " + averageTime + "ms");
        }
    }

    public void testSlicesImageRecolorMethodOutput() throws IOException {
        outputTestHelper(1);
        outputTestHelper(4);
        outputTestHelper(8);
        outputTestHelper(1024);
    }

    public void testSlicesImageRecolorMethodPerformance() throws InterruptedException {
        // To connect with JConsole
        Thread.sleep(10000);

        performanceTestHelper();
    }
}
