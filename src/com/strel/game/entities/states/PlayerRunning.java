package com.strel.game.entities.states;

import com.strel.game.animation.NewAnimation;
import com.strel.game.entities.Player;
import com.strel.game.utils.ImageLoader;

import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public class PlayerRunning extends PlayerState {

    private NewAnimation run_anim;


    public PlayerRunning(Player player) {
        super(player);

        run_anim = new NewAnimation();
        run_anim.add(ImageLoader.getDinosaurRunSprites(), 200);
        run_anim.start();
    }


    @Override
    public void update(long elapsedTime) {
        run_anim.update(elapsedTime);
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(run_anim.getImage(), player.getX(), player.getY(), null);
    }
}
