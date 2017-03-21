package com.duongnx.mvp.ui.addedittask;

import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.ui.BasePresenter;
import com.duongnx.mvp.ui.BaseView;

/**
 * Created by duongnx on 3/21/2017.
 */

public interface AddEditTaskContract {
    interface Presenter extends BasePresenter {
        void loadTask(String taskId);

        void saveTask(String title, String description);
    }

    interface View extends BaseView<Presenter> {
        void onSaveTaskComplete();

        void onLoadTaskComplete(Task task);
    }
}
