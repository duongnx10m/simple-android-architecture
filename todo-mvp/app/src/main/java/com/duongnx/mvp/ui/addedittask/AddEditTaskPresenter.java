package com.duongnx.mvp.ui.addedittask;

import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.data.TasksRepsosity;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by duongnx on 3/21/2017.
 */

public class AddEditTaskPresenter implements AddEditTaskContract.Presenter {
    private AddEditTaskContract.View mView;
    private String mTaskId = null;

    public AddEditTaskPresenter(String taskId, AddEditTaskContract.View view) {
        this.mView = view;
        this.mTaskId = taskId;
    }

    @Override
    public void loadTask(String taskId) {
        TasksRepsosity.getInstance()
                .getTask(taskId)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(task -> {
                    mView.onLoadTaskComplete(task);
                }, throwable -> {
                    mView.onLoadTaskComplete(null);
                });

    }

    @Override
    public void saveTask(String title, String description) {
        if (mTaskId == null) {
            // add new Task
            TasksRepsosity.getInstance().add(new Task(title, description));
        } else {
            // update task
            TasksRepsosity.getInstance().edit(new Task(mTaskId, title, description));
        }

        if (mView != null)
            mView.onSaveTaskComplete();
    }


}
