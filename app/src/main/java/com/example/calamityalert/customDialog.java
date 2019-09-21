package com.example.calamityalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import androidx.annotation.NonNull;

public class customDialog extends Dialog implements View.OnClickListener {

    DatabaseReference ref;
    public Activity c;
            public Dialog d;
            public Button send, cancel;
            public EditText name, no;
            LatLng latLng;


    public customDialog(Activity context, LatLng latLng) {
        super(context);
        this.c = context;
        this.latLng = latLng;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:

                ref = FirebaseDatabase.getInstance().getReference("victim");
                String key = ref.push().getKey();
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("name",name.getText().toString());
                hashMap.put("contact",no.getText().toString());
                hashMap.put("key",key);
                hashMap.put("latlng", String.valueOf(latLng));
                ref.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            Toast.makeText(c, "Successful", Toast.LENGTH_SHORT).show();

                        else Toast.makeText(c, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                    }
                });
                this.hide();
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
        name = findViewById(R.id.name);
        no = findViewById(R.id.phoneNumber);
        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


}
