package BlocksMethod;

import Helpers.ImageProcessingHelper;

public class BlocksImageRecolorMethodRunnable implements Runnable {

    private BlocksImageRecolorMethod parentProcess;

    private int xStart;
    private int xEnd;

    private int yStart;
    private int yEnd;


    /**
     * @param parentProcess Parent process that created this runnable
     * @param xStart        the starting x-coordinate of the block to be recolored
     * @param xEnd          the ending x-coordinate of the block to be recolored
     * @param yStart        the starting y-coordinate of the block to be recolored
     * @param yEnd          the ending y-coordinate of the block to be recolored
     */
    public BlocksImageRecolorMethodRunnable(BlocksImageRecolorMethod parentProcess, int xStart, int xEnd, int yStart, int yEnd) {
        this.parentProcess = parentProcess;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
    }

    @Override
    public void run() {
//        System.out.println("Thread: " + index + " started");
        recolor();
//        System.out.println("Thread: " + index + " finished");
    }

    /**
     * Recolors the block of the image from(xStart, yStart) to (xEnd, yEnd)
     */
    private void recolor() {
        for (int x = xStart; x < xEnd && x < parentProcess.originalImage.getWidth(); x++) {
            for (int y = yStart; y < yEnd && y < parentProcess.originalImage.getHeight(); y++) {
                ImageProcessingHelper.recolorPixel(parentProcess.originalImage, parentProcess.resultImage, x, y);
            }
        }
    }
}