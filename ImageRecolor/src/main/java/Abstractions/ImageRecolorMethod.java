package Abstractions;

import Helpers.OpenImageHelper;
import Helpers.SaveImageHelper;

import java.awt.image.BufferedImage;

public abstract class ImageRecolorMethod {

    protected int threadsCount;

    protected final BufferedImage originalImage;
    protected final BufferedImage resultImage;

    /**
     * @param threadsCount number of threads to use
     */
    public ImageRecolorMethod(int threadsCount) {
        this.threadsCount = threadsCount;

        originalImage = OpenImageHelper.openImage();
        resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    }

    public abstract void recolorImage();

    public void saveImage() {
        SaveImageHelper.saveImage(resultImage);
    }
}
