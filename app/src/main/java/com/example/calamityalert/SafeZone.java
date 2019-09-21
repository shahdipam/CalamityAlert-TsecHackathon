package com.example.calamityalert;

import android.provider.ContactsContract;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class SafeZone {
    static ArrayList<LatLng> latLngs = new ArrayList<>();

    public SafeZone(ArrayList<LatLng> lls){
        latLngs = lls;
    }

    public static void AddtoFirebase(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("safezones");

        for(int i=0;i<latLngs.size();i++){
            ref.push()  .setValue(String.valueOf(latLngs.get(i)));
        }
    }

    public static void Retreive(){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("safezones");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    String loc = ds.getValue().toString();
                    String[] latlong = loc.substring(10,(loc.length()-1)).split(",");
                    double latitude = Double.parseDouble(latlong[0]);
                    double longitude = Double.parseDouble(latlong[1]);
                    latLngs.add(new LatLng(latitude,longitude));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public static void CLear(){
        latLngs.clear();
    }
}
