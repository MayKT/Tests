package com.mkttestprojects.myapplication.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.mkttestprojects.myapplication.R;
import com.mkttestprojects.myapplication.common.BaseActivity;
import com.mkttestprojects.myapplication.ui.maps.MapsActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.cv_maps)
    CardView cvMaps;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {

        setupToolbar(false);

        testFirebaseMessaging();

        cvMaps.setOnClickListener(this);


    }

    private void testFirebaseMessaging() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.e(TAG, "onComplete: getInstance failed" + task.getException() );
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Log.e(TAG, "onComplete: task.getResult.getToken " + token );
                        //d451lWeKTyq2k7JjMtBkew:APA91bEz_joC8YZ6w4Dc-RZSpOR3Ni2xvh6dmchVopfSrXh93Rch9nY0_NLy4tjV1h_2bOS4dXSQhWcHqz5v5gNe7oHF4hW4i5K6Jkd74jNsLtylcIFrnPtssluwoBKGAskWcZpyZUts
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_maps:
                startActivity(MapsActivity.MapsActivityIntent(MainActivity.this));
        }
    }
}
