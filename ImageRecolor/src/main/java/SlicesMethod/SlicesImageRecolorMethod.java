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
            originalImage = OpenImageHelper.openImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        width = originalImage.getWidth();
        height = originalImage.getHeight() / threadsCount;

        resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            SlicesImageRecolorMethodRunnable task
                    = new SlicesImageRecolorMethodRunnable(this, i);
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        try {
            SaveImageHelper.saveImage(resultImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
