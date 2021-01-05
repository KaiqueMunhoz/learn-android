package com.learn.funfacts;

import android.graphics.Color;

import java.util.Random;

public class BackgroundColor {


    static public int getColor() {
        final int alpha = randomColor();
        final int red = randomColor();
        final int green = randomColor();
        final int blue = randomColor();

        return Color.argb(alpha, red, green, blue);
    }

    static private int randomColor() {
        final int maxRGBNumber = 256;
        return new Random().nextInt(maxRGBNumber);
    }

}
