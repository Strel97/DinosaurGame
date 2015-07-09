package com.strel.game.engine;

import java.awt.*;

/**
 * Created by strel on 20.05.15.
 */
public interface GameState {
    public void update(long elapsedTime);
    public void draw(Graphics2D g);
    public boolean isComplete();
}
