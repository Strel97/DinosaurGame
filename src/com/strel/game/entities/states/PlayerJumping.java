package com.strel.game.entities.states;

import com.strel.game.engine.GameConfig;
import com.strel.game.entities.Player;
import com.strel.game.utils.ImageLoader;

import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public class PlayerJumping extends PlayerState {

    private int start_y;
    private int vy;

    private boolean jumpComplete;


    public PlayerJumping(Player player) {
        super(player);

        start_y = player.getY();
        vy = GameConfig.PLAYER_JUMP_SPEED;

        jumpComplete = false;
    }

    @Override
    public void update(long elapsedTime) {
        if (player.getY() > start_y) {
            jumpComplete = true;
            player.setY(start_y);

            return;
        }

        if (player.getY() <= start_y - GameConfig.PLAYER_MAX_JUMP_HEIGHT)
            vy = -vy;

        player.setY(player.getY() + vy);
    }

    @Override
    public boolean isComplete() {
        return jumpComplete;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(ImageLoader.getDinosaurSprite(), player.getX(), player.getY(), null);
    }
}
