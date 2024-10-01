package BlocksMethod;

import Abstractions.IImageRecolorMethod;
import Helpers.OpenImageHelper;
import Helpers.SaveImageHelper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlocksImageRecolorMethod implements IImageRecolorMethod {

    private int threadsCount;

    /**
     * @param threadsCount the number of threads to use for recoloring the image
     */
    public BlocksImageRecolorMethod(int threadsCount) {
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

        // Number of threads is at most size
        int blockSize = (int) Math.sqrt(width * height / threadsCount);
        int blockCountX = (int) Math.ceil((double) width / blockSize);
        int blockCountY = (int) Math.ceil((double) height / blockSize);
        threadsCount = blockCountX * blockCountY;

        resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        List<Thread> threads = new ArrayList<>();

        // Create and start the threads
        for (int i = 0; i < blockCountY; i++) {
            for (int j = 0; j < blockCountX; j++) {
                int xStart = j * blockSize;
                int xEnd = (j == blockCountX - 1) ? width : xStart + blockSize;
                int yStart = i * blockSize;
                int yEnd = (i == blockCountY - 1) ? height : yStart + blockSize;
                BlocksImageRecolorMethodRunnable task = new BlocksImageRecolorMethodRunnable(
                        this, xStart, xEnd, yStart, yEnd);
                Thread thread = new Thread(task);
                threads.add(thread);
                thread.start();
            }
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