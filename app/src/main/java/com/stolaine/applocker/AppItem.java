package com.stolaine.applocker;

import android.graphics.drawable.Drawable;

public class AppItem implements Comparable<AppItem>{
    private String mLabel;
    private Drawable mIcon;
    private boolean mLocked;

    public AppItem(String label, Drawable icon) {
        this.mLabel = label;
        this.mIcon = icon;
        mLocked = false;
    }

    @Override
    public int compareTo(AppItem item) {
        return this.mLabel.compareTo(item.getLabel());
    }

    public String getLabel() {
        return this.mLabel;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public boolean isLocked() {
        return this.mLocked;
    }
}
