package com.duongnx.mvp.ui.addedittask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.duongnx.mvp.R;
import com.duongnx.mvp.data.Task;
import com.duongnx.mvp.ui.FrgBase;
import com.duongnx.mvp.ui.MainActivity;
import com.duongnx.mvp.utils.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by duongnx on 3/21/2017.
 */

public class FrgAddEditTask extends FrgBase implements AddEditTaskContract.View {
    private AddEditTaskContract.Presenter mPresenter;
    private String mTaskId = null;

    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etDescription)
    EditText etDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.frg_addedittask, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new AddEditTaskPresenter(mTaskId, this);

    }

    @Override
    public void onFloatButtonClicked() {
        Logger.d(getClass().getSimpleName() + ":onFloatButtonClicked");
        if (mPresenter != null && etTitle != null)
            mPresenter.saveTask(etTitle.getText().toString(), etDescription.getText().toString());
    }

    @Override
    public void onSaveTaskComplete() {
        Toast.makeText(getActivity(), "onSaveTaskComplete", Toast.LENGTH_SHORT).show();
        etTitle.getText().clear();
        etDescription.getText().clear();
    }

    @Override
    public void onLoadTaskComplete(Task task) {
        if (task != null) {
            etTitle.setText(task.getTitle());
            etDescription.setText(task.getDescription());
        }
    }

}
