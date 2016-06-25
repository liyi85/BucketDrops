package com.example.andrearodriguez.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by andrearodriguez on 6/23/16.
 */
public class Util {
    public static void showViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }
}
