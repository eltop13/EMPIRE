package gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage image;
    private int cropWidth;
    private int cropHeight;

    public SpriteSheet(BufferedImage image, int cropWidth, int cropHeight) {
        this.image = image;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    public BufferedImage crop(int x, int y) {
        return this.image.getSubimage(x*cropWidth, y*cropHeight, cropHeight, cropHeight);
    }
}