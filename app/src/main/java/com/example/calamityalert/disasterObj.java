package com.example.calamityalert;

import com.google.android.gms.maps.model.LatLng;

public class disasterObj {
    public String type, address;
    public LatLng location;

    public disasterObj(String type, LatLng location, String address) {
        this.type = type;
        this.location = location;
        this.address = address;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}