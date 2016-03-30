package com.strel.game.engine;

import com.strel.game.input.InputHandler;

import java.awt.*;

/**
 * Created by strel on 30.03.2016.
 */
public class GameEnd implements GameState {

    private boolean paused;


    public GameEnd() {
        paused = true;
    }

    public void handleInput() {
        InputHandler input = Game.getInstance().getInputHandler();
        if (input.isSpacePressed()) {
            paused = false;
            Game.getInstance().resetGame();
        }
    }

    @Override
    public void update(long elapsedTime) {
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(GameConfig.COLOR_ENTITY);

        g.drawString(
                GameConfig.GAME_NAME,
                GameConfig.GAME_NAME_X,
                GameConfig.GAME_NAME_Y
        );

        g.drawString(
                GameConfig.END_MENU_MSG,
                GameConfig.END_MENU_X,
                GameConfig.END_MENU_Y
        );
    }

    @Override
    public boolean isComplete() {
        return !paused;
    }
}
