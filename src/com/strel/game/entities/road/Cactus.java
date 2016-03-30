package com.strel.game.entities.road;

import com.strel.game.engine.GameConfig;
import com.strel.game.entities.MovingEntity;
import com.strel.game.utils.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by strel on 19.05.15.
 */
public class Cactus extends MovingEntity {

    private Random          rand;
    private BufferedImage   img;
    private int             type;


    public Cactus(int x, int y) {
        super(x, y);

        rand = new Random();
        type = rand.nextInt(GameConfig.CACTUS_TYPES);
        img = ImageLoader.getCactusSprite()[type];              // Getting random sprite for cactus

        /**
         * Logic is such, that
         */
        setWidth(img.getWidth());
        setHeight(img.getHeight());

        // Changing y to draw different type of cactus on the same y pos
        this.y = GameConfig.ROAD_Y_POS - img.getHeight() + 10;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}