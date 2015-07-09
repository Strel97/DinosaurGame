package com.strel.game;

import com.strel.game.engine.Game;

import javax.swing.*;

/**
 * Created by strel on 18.05.15.
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = Game.getInstance();

        JFrame frame = new JFrame("Dinosaur Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(game.getCanvas().getSize());
        frame.setResizable(false);

        frame.add(game.getCanvas());

        frame.setVisible(true);

        game.start();
    }
}
