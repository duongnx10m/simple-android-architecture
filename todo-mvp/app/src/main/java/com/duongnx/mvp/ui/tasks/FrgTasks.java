package com.duongnx.mvp.ui.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.mvp.R;
import com.duongnx.mvp.adapter.AdapterTasks;
import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.ui.FrgBase;
import com.duongnx.mvp.ui.addedittask.FrgAddEditTask;
import com.duongnx.mvp.utils.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duongnx on 3/21/2017.
 */

public class FrgTasks extends FrgBase implements TasksContract.View {

    private TasksContract.Presenter mPresenter;
    private AdapterTasks mAdapter;
    @BindView(R.id.tvNodata)
    TextView tvNodata;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_tasks, container, false);
        unbinder = ButterKnife.bind(this, view);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadTasks();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new TasksPresenter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        if (mAdapter == null) {
            mAdapter = new AdapterTasks(mActivity);
        }
        recyclerView.setAdapter(mAdapter);
        mPresenter.loadTasks();
    }

    @Override
    public void onFloatButtonClicked() {
        Logger.d(getClass().getSimpleName() + ":onFloatButtonClicked");
        mActivity.replaceFragment(new FrgAddEditTask());
    }

    @Override
    public void onLoadTasksComplete(List<Task> tasks) {
        Logger.d("");
        if (tasks == null || tasks.size() == 0) {
            tvNodata.setVisibility(View.VISIBLE);
        } else {
            tvNodata.setVisibility(View.GONE);
            mAdapter.setTasks(tasks);
            mAdapter.notifyDataSetChanged();
        }
        swipeRefreshLayout.setRefreshing(false);
    }


}
