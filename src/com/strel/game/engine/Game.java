package com.strel.game.engine;

import com.strel.game.GamePanel;
import com.strel.game.entities.Player;
import com.strel.game.entities.Score;
import com.strel.game.entities.road.Road;
import com.strel.game.input.InputHandler;
import com.strel.game.utils.ImageLoader;
import sun.security.krb5.SCDynamicStoreConfig;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 18.05.15.
 */
public class Game implements Runnable {

    private static Game instance;

    private GamePanel canvas;
    private InputHandler input;
    private BufferedImage img;

    private boolean running;
    private Thread  thread;
    private int     fps;

    private Player  player;
    private Road    road;

    private GameState state;


    private Game() {
        canvas = new GamePanel();
        input = new InputHandler();

        canvas.addKeyListener(input);

        int width = Math.round(canvas.getWidth() / GameConfig.SCALE);
        int height = Math.round(canvas.getHeight() / GameConfig.SCALE);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        ImageLoader.prepareImages();
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();

        return instance;
    }

    public void start() {
        if (running)
            return;

        initGame();

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        if (!running)
            return;

        running = false;
    }

    /**
     * Game goes to End state, that is responsible for
     * showing score and proposing start game again.
     */
    public void endGame() {
        state = new GameEnd();
    }

    private void initGame() {
        player = new Player(GameConfig.PLAYER_X_POS, GameConfig.PLAYER_Y_POS);
        road = new Road(GameConfig.ROAD_X_POS, GameConfig.ROAD_Y_POS);

        state = new GamePaused();
    }

    public void resetGame() {
        initGame();
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        long currTime = startTime;

        int frames = 0;
        long time = 0;

        while (running) {
            long elapsedTime = System.currentTimeMillis() - currTime;
            currTime += elapsedTime;
            time += elapsedTime;

            if (time >= 1000) {
                fps = frames;

                frames = 0;
                time = 0;
            }

            update(elapsedTime);
            render();

            frames++;


            try {
                Thread.sleep(15);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

        System.exit(0);
    }

    public void handleInput() {
        if (input.isEscapePressed())
            stop();
        else if (input.isPkeyPressed())
            setState(new GamePaused());
    }

    public void update(long elapsedTime) {
        handleInput();

        if (!state.isComplete())
            state.update(elapsedTime);
        else
            changeState(state);
    }

    public void render() {
        Graphics2D g = (Graphics2D) img.getGraphics();

        canvas.render(g);
        state.draw(g);

        canvas.getGraphics().drawImage(img, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

        g.dispose();
    }


    public GamePanel getCanvas() {
        return canvas;
    }

    public InputHandler getInputHandler() {
        return input;
    }

    public boolean isRunning() {
        return running;
    }

    public void changeState(GameState state) {
        if (state instanceof GamePaused)
            setState(new GameRunning(player, road));
        else if (state instanceof  GameRunning)
            setState(new GamePaused());
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }
}
