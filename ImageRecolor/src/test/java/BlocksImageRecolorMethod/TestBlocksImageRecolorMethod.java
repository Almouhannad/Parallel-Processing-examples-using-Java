package BlocksImageRecolorMethod;

import Abstractions.IImageRecolorMethod;
import BlocksMethod.BlocksImageRecolorMethod;
import Constants.FilesLocations;
import Helpers.ImageProcessingHelper;
import SlicesMethod.SlicesImageRecolorMethod;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestBlocksImageRecolorMethod extends TestCase {

    public void testBlocksImageRecolorMethodOutput() throws IOException {
        IImageRecolorMethod method = new BlocksImageRecolorMethod(1);
        method.recolorImage();

        BufferedImage expectedImage = null;
        expectedImage = ImageIO.read(new File(FilesLocations.CORRECT_RESULT_FILE));

        BufferedImage generatedImage = null;
        generatedImage = ImageIO.read(new File(FilesLocations.DESTINATION_FILE));

        Assert.assertTrue(ImageProcessingHelper.areImagesEqual(expectedImage, generatedImage));
    }

    public void testBlocksImageRecolorMethodOutputMultithreaded() throws IOException {
        IImageRecolorMethod method = new BlocksImageRecolorMethod(10);
        method.recolorImage();

        BufferedImage expectedImage = null;
        expectedImage = ImageIO.read(new File(FilesLocations.CORRECT_RESULT_FILE));

        BufferedImage generatedImage = null;
        generatedImage = ImageIO.read(new File(FilesLocations.DESTINATION_FILE));

        Assert.assertTrue(ImageProcessingHelper.areImagesEqual(expectedImage, generatedImage));
    }

    public void testBlocksImageRecolorMethodPerformance() {
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
                IImageRecolorMethod method = new BlocksImageRecolorMethod(threads);
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
