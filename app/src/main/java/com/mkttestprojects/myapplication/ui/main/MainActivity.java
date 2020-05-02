package com.mkttestprojects.myapplication.ui.main;

import android.os.Bundle;
import com.mkttestprojects.myapplication.R;
import com.mkttestprojects.myapplication.common.BaseActivity;
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {

        setupToolbar(false);

    }

}
