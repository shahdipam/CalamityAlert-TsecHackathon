package com.example.calamityalert;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DisasterAdapter extends ArrayAdapter<disasterObj> {

    private Context context;
    private List<disasterObj> disaster;

    public DisasterAdapter(@NonNull Context context, List<disasterObj> disaster) {
        super(context, R.layout.disasterlayout);
        this.context = context;
        this.disaster = disaster;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.disasterlayout, parent, false);
        TextView type, direction, report, update, location;

        type = convertView.findViewById(R.id.type);
        direction = convertView.findViewById(R.id.direction);
        report = convertView.findViewById(R.id.reported);
        update = convertView.findViewById(R.id.updated);
        location = convertView.findViewById(R.id.location);
//
//        type.setText(disaster.get(position).getDisType());
//        direction.setText(disaster.get(position).getDirection());
//        report.setText(disaster.get(position).getReport());
//        update.setText(disaster.get(position).getUpdate());
//        location.setText(disaster.get(position).getLocation());


        return convertView;
    }


}
