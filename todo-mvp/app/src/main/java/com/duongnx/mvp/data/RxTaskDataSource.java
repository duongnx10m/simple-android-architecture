package com.duongnx.mvp.data;

import java.util.List;

import rx.Observable;

/**
 * Created by duongnx on 3/22/2017.
 */

public interface RxTaskDataSource {

    Observable<Task> getTask(String taskId);

    Observable<List<Task>> getTasks();

}
