package com.example.calamityalert;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.Text;

public class HomeInfoWindow implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public HomeInfoWindow(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.home_map_marker, null);

        TextView header = view.findViewById(R.id.header);

        header.setText(marker.getTitle());

        return view;
    }
}
