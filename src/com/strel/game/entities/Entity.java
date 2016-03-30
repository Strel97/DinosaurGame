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

    protected int width;
    protected int height;


    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean testCollision(Entity e) {
        return ((e.getX() + e.getWidth()) >= x && (e.getX() + e.getWidth()) <= x + width) &&
                ((e.getY() + e.getHeight()) >= y && (e.getY() + e.getHeight()) <= y + height);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void update(long elapsedTime);
    public abstract void draw(Graphics2D g);
}
