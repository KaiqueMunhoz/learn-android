package com.learn.funfacts;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BackgroundColorScreen {
    final private ArrayList<Integer> colors = new ArrayList(Arrays.asList(
            Color.MAGENTA,
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DKGRAY,
            Color.RED,
            Color.YELLOW,
            Color.LTGRAY,
            Color.GREEN,
            Color.GRAY
    ));


    public int getColor() {
        final int randomNumber  = new Random().nextInt(colors.size());
        return colors.get(randomNumber);
    }

}
