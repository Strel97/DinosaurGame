package com.strel.game.engine;

import com.strel.game.entities.Player;
import com.strel.game.entities.Score;
import com.strel.game.entities.road.Road;

import java.awt.*;

/**
 * Created by strel on 20.05.15.
 */
public class GameRunning implements GameState {

    private Player  player;
    private Road    road;


    public GameRunning(Player player, Road road) {
        this.player = player;
        this.road = road;
    }

    @Override
    public void update(long elapsedTime) {
        player.update(elapsedTime);
        road.update(elapsedTime);
    }

    @Override
    public void draw(Graphics2D g) {
        road.draw(g);
        player.draw(g);
    }

    @Override
    public boolean isComplete() {
        return !Game.getInstance().isRunning();
    }
}
