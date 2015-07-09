package com.strel.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by strel on 18.05.15.
 */
public class InputHandler implements KeyListener {

    private boolean spacePressed;
    private boolean escapePressed;
    private boolean p_keyPressed;

    private boolean waitingForRelease;


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (!waitingForRelease && e.getKeyCode() == KeyEvent.VK_SPACE)
            spacePressed = true;
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            escapePressed = true;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            p_keyPressed = true;

        waitingForRelease = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            spacePressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            escapePressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            p_keyPressed = false;

        waitingForRelease = false;
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }

    public boolean isEscapePressed() {
        return escapePressed;
    }

    public boolean isPkeyPressed() { return p_keyPressed; }

    public boolean isReleased() {
        return !waitingForRelease;
    }
}
