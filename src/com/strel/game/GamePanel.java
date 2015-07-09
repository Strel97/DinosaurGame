package com.strel.game;

import com.strel.game.engine.GameConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public class GamePanel extends JPanel {

    private static int DEFAULT_WIDTH = 1000;
    private static int DEFAULT_HEIGHT = 500;


    public GamePanel() {
        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setFocusable(true);

        requestFocus();
    }

    public void render(Graphics2D g) {
        g.setColor(GameConfig.COLOR_BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
