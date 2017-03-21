package com.duongnx.mvvm.ui.home;

import android.databinding.BaseObservable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.duongnx.mvvm.data.Task;
import com.duongnx.mvvm.utils.Logger;

/**
 * Created by duongnx on 3/20/2017.
 */

public class HomeViewModel extends BaseObservable {


    public void onAddNewTasksClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
