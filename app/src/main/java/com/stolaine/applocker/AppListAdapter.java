package com.stolaine.applocker;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    private List<AppItem> mApps;
    private static final String TAG = "AppListAdapter";

    public AppListAdapter(List<AppItem> list) {
        mApps = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AppItem appItem = mApps.get(position);
        holder.imageView.setImageDrawable(appItem.getIcon());
        holder.textView.setText(appItem.getLabel());
        holder.checkBox.setChecked(appItem.isLocked());
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public CheckBox checkBox;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            imageView = itemView.findViewById(R.id.appIcon);
            textView = itemView.findViewById(R.id.appLabel);
            checkBox = itemView.findViewById(R.id.appSelection);
        }

    }
}
