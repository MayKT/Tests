package com.mkttestprojects.myapplication.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mkttestprojects.myapplication.custom_control.MyanProgressDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    protected Unbinder unbinder;

    MyanProgressDialog myanProgressDialog;

    public Context mContext;

    private int someStateValue;

    private final String SOME_VALUE_KEY = "someValueToSave";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        unbinder = ButterKnife.bind(this, view);

        mContext=view.getContext();

        myanProgressDialog = new MyanProgressDialog(mContext);

        if (savedInstanceState != null) {
            someStateValue = savedInstanceState.getInt(SOME_VALUE_KEY);
        }

        setUpContents(savedInstanceState);

        return view;
    }

    public void showToastMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        myanProgressDialog.showDialog();
    }

    public void hideProgressDialog() {
        myanProgressDialog.hideDialog();
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void setUpContents(Bundle savedInstanceState);


}
