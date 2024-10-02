package BlocksMethod;

import Helpers.ImageProcessingHelper;

import java.awt.image.BufferedImage;

class BlocksImageRecolorMethodRunnable implements Runnable {

    private final BufferedImage originalImage;
    private final BufferedImage resultImage;

    private final int xStart;
    private final int yStart;

    private final int xEnd;
    private final int yEnd;

    public BlocksImageRecolorMethodRunnable(BufferedImage originalImage, BufferedImage resultImage, int xStart, int yStart, int xEnd, int yEnd) {
        this.originalImage = originalImage;
        this.resultImage = resultImage;

        this.xStart = xStart;
        this.yStart = yStart;

        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public void run() {
        ImageProcessingHelper.recolorSection(originalImage, resultImage,
                xStart, yStart,
                xEnd, yEnd);
    }
}