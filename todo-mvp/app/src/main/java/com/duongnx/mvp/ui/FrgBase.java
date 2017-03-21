package com.duongnx.mvp.ui;

import android.content.Context;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by duongnx on 3/21/2017.
 */

public abstract class FrgBase extends Fragment {
    protected Unbinder unbinder;
    protected MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();
    }

    public void onFloatButtonClicked() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
