package Abstractions;

import java.awt.image.BufferedImage;

public interface IImageRecolorMethod {
    public void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                             int width, int height);
}
