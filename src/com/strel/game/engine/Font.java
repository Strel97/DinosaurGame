package com.strel.game.engine;

import com.strel.game.utils.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 20.05.15.
 */
public class Font {
    public static void draw( Graphics2D g, int num, int x, int y) {
        BufferedImage font = ImageLoader.loadImage("font.png");

        int len = 0;
        int n = num;
        while (n != 0) {
            n /= 10;
            len++;
        }

        int cnt = 0;        // The number of digits in number
        while (num != 0) {  // While we have at least one digit
            cnt++;

            g.drawImage(
                    font,
                    x + cnt * 12, y,                // Coordinates of draw
                    x + 12 + cnt * 12, y + 12,      // Width and Height coords
                    (num / len) * 6, 0,              // Coordinates in image
                    (num / len) * 6 + 6, 6,          // End coordinates in image
                    null
            );

            num %= len;
            len--;
        }
    }
}
