package SlicesMethod;

import Abstractions.IImageRecolorMethod;
import Helpers.OpenImageHelper;
import Helpers.SaveImageHelper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlicesImageRecolorMethod implements IImageRecolorMethod {

    private int threadsCount;

    /**
     * @param threadsCount number of threads to use for recoloring the image
     */
    public SlicesImageRecolorMethod(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    public BufferedImage originalImage;
    public BufferedImage resultImage;

    public int width;
    public int height;

    @Override
    public void recolorImage() {
        try {
            // Open the original image
            originalImage = OpenImageHelper.openImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        width = originalImage.getWidth();
        height = originalImage.getHeight();

        // Number of threads is at most height
        if (threadsCount > height) {
            threadsCount = height;
        }
        // Slice height for each thread
        int sliceHeight = (int) Math.ceil((double) height / threadsCount);

        resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        List<Thread> threads = new ArrayList<>();

        // Create and start the threads
        for (int i = 0; i < threadsCount; i++) {
            int startY = i * sliceHeight;
            int endY = (i == threadsCount - 1) ? height : startY + sliceHeight;
            SlicesImageRecolorMethodRunnable task = new SlicesImageRecolorMethodRunnable(this, startY, endY);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        // Save result image
        try {
            SaveImageHelper.saveImage(resultImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}