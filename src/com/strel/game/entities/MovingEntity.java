package com.strel.game.entities;

import com.strel.game.engine.GameConfig;


/**
 * Created by strel on 19.05.15.
 */
public abstract class MovingEntity extends Entity {

    public MovingEntity(int x, int y) {
        super(x, y);
    }

    public MovingEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update(long elapsedTime) {
        x -= GameConfig.PLAYER_RUN_SPEED;
    }
}
