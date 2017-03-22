package com.duongnx.mvp.ui.tasks;

import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.data.TasksRepsosity;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by duongnx on 3/21/2017.
 */

public class TasksPresenter implements TasksContract.Presenter {
    private TasksContract.View mView;

    public TasksPresenter(TasksContract.View view) {
        this.mView = view;
    }

    @Override
    public void loadTasks() {
        TasksRepsosity.getInstance()
                .getTasks()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tasks -> {
                    mView.onLoadTasksComplete(tasks);
                }, throwable -> {

                });
    }
}
