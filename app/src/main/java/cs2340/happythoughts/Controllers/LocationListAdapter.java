package cs2340.happythoughts.Controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cs2340.happythoughts.Models.Location;
import cs2340.happythoughts.R;

public class LocationListAdapter extends ArrayAdapter<Location> {
    private Context mContext;
    private int mResource;
    private TextView nameView;
    private TextView addressView;

    public LocationListAdapter(@NonNull Context context, int resource, ArrayList<Location> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String city = getItem(position).getCity();
        String address = getItem(position).getStreetAddress();
        String zip = getItem(position).getZip();
        String state = getItem(position).getState();

        String total = String.format("%s, %s, %s %s", address, city, state, zip);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        nameView = (TextView) convertView.findViewById(R.id.locationName);
        addressView = (TextView) convertView.findViewById(R.id.locationAddress);
        nameView.setText(name);
        addressView.setText(total);
        return convertView;
    }
}
