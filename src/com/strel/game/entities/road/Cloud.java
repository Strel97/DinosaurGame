package com.strel.game.entities.road;

import com.strel.game.entities.MovingEntity;
import com.strel.game.utils.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 20.05.15.
 */
public class Cloud extends MovingEntity {

    private BufferedImage img;


    public Cloud(int x, int y) {
        super(x, y);
        img = ImageLoader.getCloudSprite();
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}
