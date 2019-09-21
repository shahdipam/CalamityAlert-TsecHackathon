package com.example.calamityalert;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class SafeZone {
    static ArrayList<LatLng> latLngs = new ArrayList<>();

    public SafeZone(ArrayList<LatLng> lls){
        latLngs = lls;
    }
}
