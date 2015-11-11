package gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage tetrisBlock;

    public static void init() {
        background = ImageLoader.loadImage("/textures/bg.jpg");
        //tetrisBlock = ImageLoader.loadImage("/textures/tetrisBlock.png");
    }
}
