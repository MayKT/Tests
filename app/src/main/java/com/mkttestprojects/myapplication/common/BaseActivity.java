package com.mkttestprojects.myapplication.common;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.Toolbar;
import com.mkttestprojects.myapplication.R;
import com.mkttestprojects.myapplication.custom_control.MyanBoldTextView;
import com.mkttestprojects.myapplication.custom_control.MyanProgressDialog;
import com.mkttestprojects.myapplication.util.SharePreferenceHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {

    protected Unbinder unbinder;

    MyanProgressDialog myanProgressDialog;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_text)
    MyanBoldTextView toolbar_text;

    @Inject
    SharePreferenceHelper sharePreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        unbinder = ButterKnife.bind(this);
        myanProgressDialog = new MyanProgressDialog(this);
        setUpContents(savedInstanceState);
    }

    protected void setupToolbar(boolean isChild) {

        if (toolbar != null)
            setSupportActionBar(toolbar);

        if (isChild) {
            if (getSupportActionBar() != null) {

                /*final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
                upArrow.setColorFilter(getResources().getColor(R.color.colorTextColorPrimary), PorterDuff.Mode.SRC_ATOP);
                getSupportActionBar().setHomeAsUpIndicator(upArrow);*/


                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                toolbar.setNavigationIcon(R.drawable.ic_back_white);
            }
        }
    }

    protected void setupToolbarColored(boolean isChild) {

        if (toolbar != null)
            setSupportActionBar(toolbar);

        if (isChild) {
            if (getSupportActionBar() != null) {

                /*final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
                upArrow.setColorFilter(getResources().getColor(R.color.colorTextColorPrimary), PorterDuff.Mode.SRC_ATOP);
                getSupportActionBar().setHomeAsUpIndicator(upArrow);*/


                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                toolbar.setNavigationIcon(R.drawable.ic_back_red);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    protected void setupToolbarText(String text) {
        //getSupportActionBar().setTitle(text);
        toolbar_text.setMyanmarText(text);
    }

    protected void setupToolbarBgColor(String color) {
        toolbar.setBackgroundColor(Color.parseColor(color));
    }

    protected void setupToolbarTextColor(String color) {
//        toolbar.setTitleTextColor(Color.parseColor(color));
        toolbar_text.setTextColor(Color.parseColor(color));
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void setUpContents(Bundle savedInstanceState);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        authenticateUserLogin();

//        forceUpdate();
    }

    public void showToastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        myanProgressDialog.showDialog();
    }

    public void hideProgressDialog() {
        myanProgressDialog.hideDialog();
    }

    /**
     * Check App Store for update.
     * */
//    private void forceUpdate() {
//        PackageManager packageManager = this.getPackageManager();
//        PackageInfo packageInfo;
//        try {
//            packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
//            String currentVersion = packageInfo.versionName;
//
//            new ForceUpdateAsync(currentVersion, BaseActivity.this).execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
