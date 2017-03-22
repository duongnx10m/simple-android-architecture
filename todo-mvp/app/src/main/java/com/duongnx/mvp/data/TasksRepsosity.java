package com.duongnx.mvp.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by duongnx on 3/21/2017.
 */

public class TasksRepsosity implements RxTaskDataSource {
    private static TasksRepsosity instance;
    private ArrayList<Task> tasks = new ArrayList<>();

    private TasksRepsosity() {
    }

    public static TasksRepsosity getInstance() {
        if (instance == null) {
            instance = new TasksRepsosity();
        }
        return instance;
    }

    public void add(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    public void edit(Task task) {
        if (task != null) {
            for (Task task1 : tasks) {
                if (task1.getId() == task.getId()) {
                    task1.setTitle(task.getTitle());
                    task1.setDescription(task.getDescription());
                    break;
                }
            }
        }
    }

    public void remove(@NonNull String taskId) {
        checkNotNull(taskId);
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                break;
            }
        }
    }

    private Task getTaskWithId(@NonNull String taskId) {
        checkNotNull(taskId);
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }


    public void clear() {
        tasks.clear();
    }

    @Override
    public Observable<Task> getTask(String taskId) {
        Task task = getTaskWithId(taskId);
        if (task != null)
            return Observable.just(task);
        else
            return null;
    }

    @Override
    public Observable<List<Task>> getTasks() {
        return Observable.from(tasks).toList();
    }
}
