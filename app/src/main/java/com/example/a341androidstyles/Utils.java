package com.example.a341androidstyles;

import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_BLACK = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;

    public static void changeToTheme(MainActivity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(MainActivity activity) {
        switch (sTheme) {
            default:
            case THEME_BLACK:
                activity.setTheme(R.style.BlackTheme);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.GreenTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.BlueTheme);
                break;
        }
    }
}