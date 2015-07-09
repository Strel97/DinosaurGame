package com.strel.game.engine;

import java.awt.*;

/**
 * Created by strel on 19.05.15.
 */
public interface GameConfig {

    public int DEFAULT_WIDTH            = 1000;
    public int DEFAULT_HEIGHT           = 500;
    public int SCALE                    = 3;

    public Color COLOR_BACKGROUND       = new Color(0xF7F7F7);
    public Color COLOR_ENTITY           = new Color(0x535353);

    public String   GAME_NAME           = "--- DINOSAUR RUN ---";
    public int      GAME_NAME_X        = DEFAULT_WIDTH / (SCALE * 2) - GAME_NAME.length() * SCALE - 5;
    public int      GAME_NAME_Y        = DEFAULT_HEIGHT / (SCALE * 2) - 20;

    public String   PAUSE_MENU_MSG      = "<< Press space to continue >>";
    public int      PAUSE_MENU_X        = DEFAULT_WIDTH / (SCALE * 2) - PAUSE_MENU_MSG.length() * SCALE - 10;
    public int      PAUSE_MENU_Y        = DEFAULT_HEIGHT / (SCALE * 2) - 5;

    public int PLAYER_X_POS             = 10;
    public int PLAYER_Y_POS             = 70;
    public int PLAYER_DIMENSION         = 45;
    public int PLAYER_MAX_JUMP_HEIGHT   = 60;
    public int PLAYER_JUMP_SPEED        = -3;
    public int PLAYER_RUN_SPEED         = 6;

    public int SCORE_X_POS              = 10;
    public int SCORE_Y_POS              = 10;

    public int ROAD_X_POS               = 0;
    public int ROAD_Y_POS               = 105;
    public int ROAD_HEIGHT              = 10;

    public int STONE_GEN_CHANCE         = 5;
    public int STONE_GEN_X              = DEFAULT_WIDTH / SCALE + 5;
    public int STONE_MAX_WIDTH          = 3;

    public int HILLOCK_HEIGHT           = 5;
    public int HILLOCK_GEN_CHANCE       = 100;
    public int HILLOCK_GEN_X            = DEFAULT_WIDTH / SCALE + 5;
    public int HILLOCK_GEN_Y            = ROAD_Y_POS - HILLOCK_HEIGHT;

    public int CLOUD_GEN_CHANCE         = 50;
    public int CLOUD_GEN_X              = DEFAULT_WIDTH / SCALE + 10;
    public int CLOUD_GEN_Y              = 10;
    public int CLOUD_GEN_Y_OFFSET       = 50;

    public int CACTUS_HEIGHT            = 35;
    public int CACTUS_WIDTH             = 35;
    public int CACTUS_TYPES             = 3;
    public int CACTUS_GEN_CHANCE        = 150;
    public int CACTUS_GEN_X             = DEFAULT_WIDTH / SCALE + 10;
    public int CACTUS_GEN_Y             = ROAD_Y_POS - CACTUS_HEIGHT + 10;

    public int OBJECTS_MAX_CNT          = 100;
}
