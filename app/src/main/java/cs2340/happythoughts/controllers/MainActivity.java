package cs2340.happythoughts.controllers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import cs2340.happythoughts.models.DonationItem;
import cs2340.happythoughts.models.DonationItemsManager;
import cs2340.happythoughts.models.Location;
import cs2340.happythoughts.models.LocationsManager;
import cs2340.happythoughts.R;

public class MainActivity extends AppCompatActivity {
    private Button mLogoutButton;
    private Button mAddDonation;
    private Button mSearchDonation;
    private Button mMapButton;
    private static ArrayList<Location> locations;
    private ListView locationListView;
    public static final ArrayList<DonationItem> donationsList = new ArrayList<>();
    public static String currentUser;
    private final LocationsManager locationsManager = LocationsManager.getInstance();
    private DonationItemsManager donationItemsManager = DonationItemsManager.getInstance();
    private HashMap<String, String> userTypeForUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            populateCredentials();
        } catch(Exception e) {
            throw new RuntimeException("Problem with credentials population!");
        }
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        mLogoutButton = findViewById(R.id.logoutButton);
        mAddDonation = findViewById(R.id.addDonationButton);
        mSearchDonation = findViewById(R.id.searchButton);
        mMapButton = findViewById(R.id.mapButton);
        locations = new ArrayList<>();
        readLocationData();
        locationListView = findViewById(R.id.locationList);
        LocationListAdapter adapter = new LocationListAdapter(this, R.layout.layout_list_item, locations);
        locationListView.setAdapter(adapter);

        mAddDonation.setEnabled(false);
        if(userTypeForUser.get(LoginActivity.currentUser).equals("Location Employee")) {
            mAddDonation.setEnabled(true);
        }
    }

    private void setupListeners() {
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        mAddDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDonation();
            }
        });

        mSearchDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDonation();
            }
        });

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMap();
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
                intent.putExtra("phone", "Phone: " + locations.get(position).getPhoneNumber());
                intent.putExtra("coordinates", "Coordinates: (" + Double.toString(
                        locations.get(position).getLatitude()) + ", " + Double.toString(
                        locations.get(position).getLongitude()) + ")");
                startActivity(intent);
            }
        });
    }

    private void goToMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    private void searchDonation() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    private void addDonation() {
        Intent intent = new Intent(this, AddDonationActivity.class);
        startActivity(intent);
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
                locationsManager.addLocation(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }


    private void populateCredentials() {
        SharedPreferences mPrefs = getSharedPreferences("userData", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("userTypeForUser", "");
        userTypeForUser = (HashMap<String, String>) gson.fromJson(json, HashMap.class);
    }
}
