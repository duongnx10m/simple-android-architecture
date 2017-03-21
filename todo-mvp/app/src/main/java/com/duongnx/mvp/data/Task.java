package com.duongnx.mvp.data;

import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * Created by duongnx on 3/21/2017.
 */

public class Task {
    @NonNull
    private String id, title, description;

    public Task(@NonNull String title, @NonNull String description) {
        this(UUID.randomUUID().toString(), title, description);
    }

    public Task(@NonNull String id, @NonNull String title, @NonNull String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
