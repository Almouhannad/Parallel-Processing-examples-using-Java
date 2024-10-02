package SlicesMethod;

import Helpers.ImageProcessingHelper;

import java.awt.image.BufferedImage;

class SlicesImageRecolorMethodRunnable implements Runnable {

    private final BufferedImage originalImage;
    private final BufferedImage resultImage;

    private final int yStart;
    private final int yEnd;

    public SlicesImageRecolorMethodRunnable(BufferedImage originalImage, BufferedImage resultImage, int yStart, int yEnd) {
        this.originalImage = originalImage;
        this.resultImage = resultImage;

        this.yStart = yStart;
        this.yEnd = yEnd;
    }

    @Override
    public void run() {
        ImageProcessingHelper.recolorSection(originalImage, resultImage,
                0, yStart,
                originalImage.getWidth(), yEnd);
    }

}