package com.duongnx.mvp.ui.tasks;

import com.duongnx.mvp.data.TasksRepsosity;

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
        if (mView != null)
            mView.onLoadTasksComplete(TasksRepsosity.getInstance().getAll());
    }
}
