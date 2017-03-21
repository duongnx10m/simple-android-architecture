package com.duongnx.mvp.ui.tasks;

import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.ui.BasePresenter;
import com.duongnx.mvp.ui.BaseView;

import java.util.List;

/**
 * Created by duongnx on 3/21/2017.
 */

public interface TasksContract {

    interface View extends BaseView {
        void onLoadTasksComplete(List<Task> tasks);
    }

    interface Presenter extends BasePresenter {
        void loadTasks();
    }
}
