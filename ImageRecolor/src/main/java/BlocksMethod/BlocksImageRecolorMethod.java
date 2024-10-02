package BlocksMethod;

import Abstractions.ImageRecolorMethod;

import java.util.ArrayList;
import java.util.List;

public class BlocksImageRecolorMethod extends ImageRecolorMethod {


    /**
     * @param threadsCount number of threads to use
     */
    public BlocksImageRecolorMethod(int threadsCount) {
        super(threadsCount);
    }

    @Override
    public void recolorImage() {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // Block size for each thread
        int blockSize = (int) Math.sqrt(width * height / threadsCount);
        int blockCountX = (int) Math.ceil((double) width / blockSize);
        int blockCountY = (int) Math.ceil((double) height / blockSize);
        // Number of threads is at most size
        threadsCount = blockCountX * blockCountY;

        // Create and start the threads
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < blockCountY; i++) {
            for (int j = 0; j < blockCountX; j++) {

                int xStart = j * blockSize;
                int yStart = i * blockSize;

                int xEnd = (j == blockCountX - 1) ? width : xStart + blockSize;
                int yEnd = (i == blockCountY - 1) ? height : yStart + blockSize;

                BlocksImageRecolorMethodRunnable task = new BlocksImageRecolorMethodRunnable(originalImage, resultImage,
                        xStart, yStart,
                        xEnd, yEnd);
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
    }
}