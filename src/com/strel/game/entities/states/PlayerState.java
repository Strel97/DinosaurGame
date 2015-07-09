package com.strel.game.entities.states;

import com.strel.game.entities.Player;

/**
 * Created by strel on 19.05.15.
 */
public abstract class PlayerState implements EntityState {

    protected Player player;


    public PlayerState(Player player) {
        this.player = player;
    }
}
