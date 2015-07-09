package com.strel.game.entities.road;

import com.strel.game.engine.GameConfig;
import com.strel.game.entities.Entity;

import java.awt.*;

/**
 * Created by strel on 19.05.15.
 */
public class RoadObjects {

    private Entity[] objects;
    private int cnt;


    public RoadObjects() {
        objects = new Entity[GameConfig.OBJECTS_MAX_CNT];
        cnt = 0;
    }

    public void add(Entity e) {
        int id = findFreeCell();

        if (id == -1)
            return;

        objects[id] = e;
        cnt++;
    }

    public boolean has(int id) {
        return objects[id] != null;
    }

    public Entity get(int id) {
        return objects[id];
    }

    public void remove(int id) {
        objects[id] = null;
        cnt--;
    }

    public int findFreeCell() {
        for (int i = 0; i < objects.length; i++)
            if (objects[i] == null)
                return i;

        return -1;
    }

    public void update(long elapsedTime) {
        for (Entity e : objects)
            if (e != null)
                e.update(elapsedTime);
    }

    public void draw(Graphics2D g) {
        for (Entity e : objects)
            if (e != null)
                e.draw(g);
    }

    public int getSize() {
        return objects.length;
    }
}
