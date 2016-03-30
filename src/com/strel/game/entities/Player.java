package com.strel.game.entities;

import com.strel.game.engine.Game;
import com.strel.game.engine.GameConfig;
import com.strel.game.entities.states.EntityState;
import com.strel.game.entities.states.PlayerDying;
import com.strel.game.entities.states.PlayerJumping;
import com.strel.game.entities.states.PlayerRunning;
import com.strel.game.input.InputHandler;

import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public class Player extends Entity {

    private EntityState state;


    public Player(int x, int y) {
        super(x, y, GameConfig.PLAYER_DIMENSION, GameConfig.PLAYER_DIMENSION);
        state = new PlayerRunning(this);
    }
    

    public void handleInput() {
         InputHandler input = Game.getInstance().getInputHandler();
        if (input.isSpacePressed()) {
            // If previous state complete
            if (state.isComplete()) {
                // Jump again
                state = new PlayerJumping(this);
            }
        }
        // if not running and previous state complete, run again
        else if (!(state instanceof PlayerRunning) && state.isComplete())
            state = new PlayerRunning(this);
    }

    /**
     * Player kills himself and game ends. It may be provoked by
     * another entity (cactus).
     */
    public void suicide() {
        state = new PlayerDying(this);
    }

    @Override
    public void update(long elapsedTime) {
        handleInput();
        state.update(elapsedTime);
    }

    @Override
    public void draw(Graphics2D g) {
        // Draw small black rectangle to merge
        // road and dino tail
        g.setColor(GameConfig.COLOR_BACKGROUND);
        g.fillRect(
                x + 6,
                y + 28,
                20,
                10
        );

        state.draw(g);
    }
}
