package com.strel.game.entities.road;


import com.strel.game.engine.Game;
import com.strel.game.engine.GameConfig;
import com.strel.game.GamePanel;
import com.strel.game.entities.Entity;
import com.strel.game.entities.Player;

import java.awt.*;
import java.util.*;

/**
 * Created by strel on 19.05.15.
 */
public class Road extends Entity {

    private Random rand;
    private RoadObjects objects;


    public Road(int x, int y) {
        super(x, y, GameConfig.DEFAULT_WIDTH, GameConfig.ROAD_HEIGHT);
        rand = new Random();

        objects = new RoadObjects();
    }

    @Override
    public void update(long elapsedTime) {
        // Generating stones
        if (rand.nextInt(GameConfig.STONE_GEN_CHANCE) == 1)
            generateStone();

        // Generating Hillocks
        if (rand.nextInt(GameConfig.HILLOCK_GEN_CHANCE) == 1)
            generateHillock();

        // Generating Clouds
        if (rand.nextInt(GameConfig.CLOUD_GEN_CHANCE) == 1)
            generateCloud();

        // Generating Cactus
        if (rand.nextInt(GameConfig.CACTUS_GEN_CHANCE) == 1)
            generateCactus();

        objects.update(elapsedTime);

        for (int i = 0; i < objects.getSize(); i++) {
            if (objects.has(i)) {
                if (objects.get(i).getX() < -5) {
                    objects.remove(i);
                }
            }
        }
    }

    private void generateHillock() {
        int x = GameConfig.HILLOCK_GEN_X;
        int y = GameConfig.HILLOCK_GEN_Y;

        objects.add(new Hillock(x, y));
    }

    public void generateStone() {
        int x = GameConfig.STONE_GEN_X;
        int y = rand.nextInt(GameConfig.ROAD_HEIGHT) + GameConfig.ROAD_Y_POS + 6;
        int len = rand.nextInt(GameConfig.STONE_MAX_WIDTH) + 1;

        objects.add( new Stone(x, y, len) );
    }

    public void generateCloud() {
        int x = GameConfig.CLOUD_GEN_X;
        int y = GameConfig.CLOUD_GEN_Y + rand.nextInt(GameConfig.CLOUD_GEN_Y_OFFSET);

        objects.add(new Cloud(x, y));
    }

    public void generateCactus() {
        int x = GameConfig.CACTUS_GEN_X;
        int y = GameConfig.CACTUS_GEN_Y;

        objects.add(new Cactus(x, y));
    }

    public boolean testCollision(Player player) {
        return objects.testCollision(player);
    }

    @Override
    public void draw(Graphics2D g) {
        GamePanel canvas = Game.getInstance().getCanvas();

        g.setColor(GameConfig.COLOR_ENTITY);

        g.drawLine(x, y, canvas.getWidth(), y); // Draw the horizon line
        objects.draw(g);
    }
}
