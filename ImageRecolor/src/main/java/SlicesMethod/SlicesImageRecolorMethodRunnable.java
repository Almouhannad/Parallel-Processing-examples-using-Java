package SlicesMethod;

import Helpers.ImageProcessingHelper;

public class SlicesImageRecolorMethodRunnable implements Runnable {

    private SlicesImageRecolorMethod parentProcess;

    // Start and end values of height
    private int startY;
    private int endY;


    /**
     * @param parentProcess the parent process that created this runnable
     * @param startY        the starting y-coordinate of the slice to be recolored
     * @param endY          the ending y-coordinate of the slice to be recolored
     */
    public SlicesImageRecolorMethodRunnable(SlicesImageRecolorMethod parentProcess, int startY, int endY) {
        this.parentProcess = parentProcess;
        this.startY = startY;
        this.endY = endY;
    }

    @Override
    public void run() {
//        System.out.println("Thread: " + index + " started");
        recolor();
//        System.out.println("Thread: " + index + " finished");
    }

    /**
     * Recolors the slice of the image from (0,startY) to (width, endY)
     */
    private void recolor() {
        for (int x = 0; x < parentProcess.width; x++) {
            for (int y = startY; y < endY && y < parentProcess.originalImage.getHeight(); y++) {
                ImageProcessingHelper.recolorPixel(parentProcess.originalImage, parentProcess.resultImage, x, y);
            }
        }
    }
}