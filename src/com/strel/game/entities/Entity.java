package com.strel.game.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 18.05.15.
 */
public abstract class Entity {

    protected BufferedImage img;

    protected int x;
    protected int y;


    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public abstract void update(long elapsedTime);
    public abstract void draw(Graphics2D g);
}
