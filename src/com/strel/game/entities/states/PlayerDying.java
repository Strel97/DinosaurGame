package com.strel.game.entities.states;

import com.strel.game.engine.Game;
import com.strel.game.engine.GamePaused;
import com.strel.game.entities.Player;

import java.awt.*;

/**
 * Created by strel on 30.03.2016.
 */
public class PlayerDying extends PlayerState {

    public PlayerDying(Player player) {
        super(player);
    }

    @Override
    public void update(long elapsedTime) {
        Game.getInstance().endGame();
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
