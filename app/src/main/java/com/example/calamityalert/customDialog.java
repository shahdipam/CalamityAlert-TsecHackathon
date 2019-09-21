package com.example.calamityalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

public class customDialog extends Dialog implements View.OnClickListener {

    public Activity c;
            public Dialog d;
            public Button send, cancel;


    public customDialog(Activity context) {
        super(context);
        this.c = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:

                VictimHelpDetails details = new VictimHelpDetails();
//                details.setName();
        break;
            case R.id.cancel:
                this.hide();
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.help_popup);
        send = findViewById(R.id.send);
        cancel = findViewById(R.id.cancel);
        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


}
