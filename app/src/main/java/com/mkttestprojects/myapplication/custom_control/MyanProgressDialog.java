package com.mkttestprojects.myapplication.custom_control;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mkttestprojects.myapplication.R;

public class MyanProgressDialog {

    private Dialog dialog;

    public MyanProgressDialog(Context context)
    {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.progress_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void showDialog()
    {
        dialog.show();
    }

    public void hideDialog()
    {
        dialog.dismiss();
    }

}
