package com.example.calamityalert;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomMapMarkerWindow implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomMapMarkerWindow(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.map_marker, null);

        TextView name = (TextView)view.findViewById(R.id.name);
        TextView contact = (TextView)view.findViewById(R.id.contact);

        name.setText("NAME: "+marker.getTitle());
        contact.setText("CONTACT: "+marker.getSnippet());

        VictimHelpDetails victimHelpDetails = (VictimHelpDetails)marker.getTag();

        return view;
    }
}
