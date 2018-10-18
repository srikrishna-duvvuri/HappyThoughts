package cs2340.happythoughts.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import cs2340.happythoughts.Models.Location;
import cs2340.happythoughts.R;

public class MainActivity extends AppCompatActivity {
    private Button mLogoutButton;
    private ArrayList<Location> locations;
    private ListView locationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        mLogoutButton = findViewById(R.id.logoutButton);
        locations = new ArrayList<>();
        readLocationData();
        locationListView = findViewById(R.id.locationList);
        LocationListAdapter adapter = new LocationListAdapter(this, R.layout.layout_list_item, locations);
        locationListView.setAdapter(adapter);
    }

    private void setupListeners() {
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), LocationDetailsActivity.class);
                intent.putExtra("name", locations.get(position).getName());
                intent.putExtra("type", locations.get(position).getType());
                intent.putExtra("address", "Address: " + locations.get(position).
                        getStreetAddress() + ", " + locations.get(position).getCity() + ", " +
                        locations.get(position).getZip());
                intent.putExtra("phone", locations.get(position).getPhoneNumber());
                intent.putExtra("website", locations.get(position).getWebsite());
                intent.putExtra("coordinates", "Coordinates: (" + Double.toString(
                        locations.get(position).getLatitude()) + ", " + Double.toString(
                        locations.get(position).getLongitude()) + ")");
                startActivity(intent);
            }
        });
    }

    private void logout() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    private void readLocationData() {
        InputStream instream = getResources().openRawResource(R.raw.locationdata);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(instream, Charset.forName("UTF-8")));
        String ln;
        try {
            //skip header line
            reader.readLine();
            while ((ln = reader.readLine()) != null) {
                String[] tokens = ln.split(",");
                Location location = new Location();
                location.setKey(Integer.parseInt(tokens[0]));
                location.setName(tokens[1]);
                location.setLatitude(Double.parseDouble(tokens[2]));
                location.setLongitude(Double.parseDouble(tokens[3]));
                location.setStreetAddress(tokens[4]);
                location.setCity(tokens[5]);
                location.setState(tokens[6]);
                location.setZip(tokens[7]);
                location.setType(tokens[8]);
                location.setPhoneNumber(tokens[9]);
                location.setWebsite(tokens[10]);
                locations.add(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
