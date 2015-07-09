package com.strel.game.entities;

import com.strel.game.engine.Font;
import com.strel.game.engine.GameConfig;

import java.awt.*;

/**
 * Created by strel on 20.05.15.
 */
public class Score extends Entity {

    private double score;


    public Score(int x, int y) {
        super(x, y);
        score = 0;
    }

    @Override
    public void update(long elapsedTime) {
        score += 0.1;
    }

    @Override
    public void draw(Graphics2D g) {
        Font.draw(
                g,
                (int)Math.round(score),
                GameConfig.SCORE_X_POS,
                GameConfig.SCORE_Y_POS
        );
    }
}
