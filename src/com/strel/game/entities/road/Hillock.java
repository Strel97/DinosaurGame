package com.strel.game.entities.road;

import com.strel.game.entities.MovingEntity;
import com.strel.game.utils.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 19.05.15.
 */
public class Hillock extends MovingEntity {

    private BufferedImage img;


    public Hillock(int x, int y) {
        super(x, y);
        img = ImageLoader.getHillockSprite();
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}
