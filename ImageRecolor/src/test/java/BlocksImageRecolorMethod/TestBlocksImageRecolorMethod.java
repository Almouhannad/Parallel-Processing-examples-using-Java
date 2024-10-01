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
}
