package com.strel.game.entities.states;

import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public interface EntityState {
    public void update(long elapsedTime);
    public void draw(Graphics2D g);
    public boolean isComplete();
}
