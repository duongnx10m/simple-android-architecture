package com.duongnx.mvp.ui.addedittask;

import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.data.TasksRepsosity;

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
        if (mView != null)
            mView.onLoadTaskComplete(TasksRepsosity.getInstance().getTask(taskId));
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
