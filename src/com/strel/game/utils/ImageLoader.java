package com.strel.game.utils;

import com.strel.game.engine.GameConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by strel on 19.05.15.
 */
public class ImageLoader {

    private static BufferedImage     font;

    private static BufferedImage[]   dinosaur_run = new BufferedImage[2];
    private static BufferedImage     dinosaur_stay;
    private static BufferedImage     hillock;
    private static BufferedImage     cloud;
    private static BufferedImage[]   cactus = new BufferedImage[GameConfig.CACTUS_TYPES];


    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;

        try {
            File file = new File("res/" + filename);
            if (file.exists())
                img = ImageIO.read(file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return img;
    }

    public static void prepareImages() {
        font = loadImage("font.png");

        dinosaur_run[0] = loadImage("dinosaur_run1.png");
        dinosaur_run[1] = loadImage("dinosaur_run2.png");

        dinosaur_stay = loadImage("dinosaur.png");

        hillock = loadImage("hillock.png");
        cloud = loadImage("cloud.png");

        cactus[0] = loadImage("cactus1.png");
        cactus[1] = loadImage("cactus2.png");
        cactus[2] = loadImage("cactus3.png");
    }

    public static BufferedImage getFont() {
        return font;
    }

    public static BufferedImage[] getDinosaurRunSprites() {
        return dinosaur_run;
    }

    public static BufferedImage getDinosaurSprite() {
        return dinosaur_stay;
    }

    public static BufferedImage getHillockSprite() {
        return hillock;
    }

    public static BufferedImage getCloudSprite() {
        return cloud;
    }

    public static BufferedImage[] getCactusSprite() {
        return cactus;
    }
}
