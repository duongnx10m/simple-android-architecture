package com.duongnx.mvvm.data;

import java.util.UUID;

/**
 * Created by duongnx on 3/20/2017.
 */

public class Task {
    private String id;
    private String title;
    private String description;

    public Task(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description) {
        this(UUID.randomUUID().toString(), title, description);
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
