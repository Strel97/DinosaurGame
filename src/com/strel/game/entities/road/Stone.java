package com.strel.game.entities.road;

import com.strel.game.engine.GameConfig;
import com.strel.game.entities.MovingEntity;

import java.awt.*;

/**
 * Created by strel on 19.05.15.
 */
public class Stone extends MovingEntity {

    private int len;


    public Stone(int x, int y, int len) {
        super(x, y);
        this.len = len;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(GameConfig.COLOR_ENTITY);
        g.drawLine(x, y, x + len, y);
    }
}
