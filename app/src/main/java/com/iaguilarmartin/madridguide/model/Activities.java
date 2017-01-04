package com.iaguilarmartin.madridguide.model;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Activities implements IElementsUpdate<Activity>, IElementsIterate<Activity> {

    private List<Activity> activities;

    public static @NonNull Activities build(@NonNull List<Activity> activityList) {
        Activities activities = new Activities();

        if (activityList == null) {
            activities.activities = new ArrayList<>();
        } else {
            activities.activities = activityList;
        }

        return activities;
    }

    private Activities() {
    }

    @Override
    public long size() {
        return activities.size();
    }

    @Override
    public @Nullable
    Activity get(final long index) {
        if (index > size() || index < 0) {
            return null;
        }
        return activities.get((int)index);
    }

    @Override
    public @NonNull
    List<Activity> allElements() {
        return this.activities;
    }

    @Override
    public void add(@NonNull final Activity activity) {
        this.activities.add(activity);
    }

    @Override
    public void delete(@NonNull final Activity activity) {
        this.activities.remove(activity);
    }

    @Override
    public void edit(@NonNull final Activity activity, final long index) {
        if (index > size() || index < 0) {
            return;
        }
        this.activities.set((int) index, activity);
    }
}
