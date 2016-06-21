package com.example.andrearodriguez.bucketdrops.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andrearodriguez on 6/21/16.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        public DropHolder(View itemView) {
            super(itemView);
        }
    }
}
