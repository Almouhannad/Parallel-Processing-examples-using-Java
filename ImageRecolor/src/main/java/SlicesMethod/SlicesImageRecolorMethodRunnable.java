package SlicesMethod;

import Helpers.ImageProcessingHelper;

import java.awt.image.BufferedImage;

public class SlicesImageRecolorMethodRunnable implements Runnable {

    private SlicesImageRecolorMethod parentProcess;
    private int index;

    public SlicesImageRecolorMethodRunnable(SlicesImageRecolorMethod parentProcess, int index) {
        this.parentProcess = parentProcess;
        this.index = index;
    }

    @Override
    public void run() {
        int xOrigin = 0;
        int yOrigin = parentProcess.height * index;

        recolor(
                parentProcess.originalImage,
                parentProcess.resultImage,
                xOrigin,
                yOrigin,
                parentProcess.width,
                parentProcess.height
        );
    }

    private void recolor(BufferedImage originalImage,
                         BufferedImage resultImage,
                         int leftCorner, int topCorner,
                         int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                ImageProcessingHelper.recolorPixel(originalImage, resultImage, x, y);
            }
        }
    }
}
