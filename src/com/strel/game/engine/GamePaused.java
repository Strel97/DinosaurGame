package com.strel.game.engine;

import com.strel.game.input.InputHandler;

import java.awt.*;

/**
 * Created by strel on 20.05.15.
 */
public class GamePaused implements GameState {

    private boolean paused;


    public GamePaused() {
        paused = true;
    }

    public void handleInput() {
        InputHandler input = Game.getInstance().getInputHandler();
        if (input.isSpacePressed())
            paused = false;
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
                GameConfig.PAUSE_MENU_MSG,
                GameConfig.PAUSE_MENU_X,
                GameConfig.PAUSE_MENU_Y
        );
    }

    @Override
    public boolean isComplete() {
        return !paused;
    }
}
