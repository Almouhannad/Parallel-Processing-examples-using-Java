package SlicesMethod;

import Abstractions.ImageRecolorMethod;

import java.util.ArrayList;
import java.util.List;

public class SlicesImageRecolorMethod extends ImageRecolorMethod {

    /**
     * @param threadsCount number of threads to use
     */
    public SlicesImageRecolorMethod(int threadsCount) {
        super(threadsCount);
    }

    @Override
    public void recolorImage() {

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // Number of threads is at most height
        if (threadsCount > height) {
            threadsCount = height;
        }

        // Slice height for each thread
        int sliceHeight = (int) Math.ceil((double) height / threadsCount);

        // Create and start the threads
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            int yStart = i * sliceHeight;
            int yEnd = (i == threadsCount - 1) ? height : yStart + sliceHeight;
            SlicesImageRecolorMethodRunnable task = new SlicesImageRecolorMethodRunnable(originalImage, resultImage,
                    yStart, yEnd);
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
    }
}