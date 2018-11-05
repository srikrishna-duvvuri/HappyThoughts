package cs2340.happythoughts.Controllers;

import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs2340.happythoughts.Models.Category;
import cs2340.happythoughts.Models.DonationItem;
import cs2340.happythoughts.Models.DonationItemsManager;
import cs2340.happythoughts.Models.Location;
import cs2340.happythoughts.Models.LocationsManager;
import cs2340.happythoughts.R;

public class SearchActivity extends AppCompatActivity {

    private TextView name;
    private Spinner locationSpinner;
    private List<Location> locations;
    private Spinner categorySpinner;
    private ListView donationList;
    private TextView message;

    private DonationItemsManager donationItemsManager = DonationItemsManager.getInstance();
    private LocationsManager locationsManager = LocationsManager.getInstance();

    private ArrayList<DonationItem> returnList;
    private ArrayAdapter<DonationItem> donationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        categorySpinner = findViewById(R.id.categorySpinner);
        locationSpinner = findViewById(R.id.locationSpinner);

        locations = locationsManager.getLocations();
        locations.add(0, locationsManager.getAllLocation());
        SpinnerAdapter locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locationSpinner.setAdapter(locationAdapter);

        SpinnerAdapter categoryArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Category.values());
        ((ArrayAdapter) categoryArrayAdapter).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryArrayAdapter);

        donationList = findViewById(R.id.donationList);
        returnList = new ArrayList<>();

        String[] array = new String[returnList.size()];

        ArrayAdapter<String> donationAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item_1, array);
        donationList.setAdapter(donationAdapter);

        donationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, ItemDetailsActivity.class);
                intent.putExtra("location", returnList.get(position).getLocation().getName());
                intent.putExtra("shortd", returnList.get(position).getShortDescription());
                intent.putExtra("fulld", returnList.get(position).getFullDescription());
                intent.putExtra("value", returnList.get(position).getValue());
                intent.putExtra("time", returnList.get(position).getTime());
                intent.putExtra("type", returnList.get(position).getCategory());
                startActivity(intent);
            }
        });

        this.message = findViewById(R.id.message);
        message.setVisibility(View.GONE);

        this.name = findViewById(R.id.name);
        this.locationSpinner = findViewById(R.id.locationSpinner);
        this.categorySpinner = findViewById(R.id.categorySpinner);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onSearchByCategory(View view) {
        message.setVisibility(View.GONE);
        returnList = donationItemsManager.searchByCategory((Location) locationSpinner.getSelectedItem(),
                (Category) categorySpinner.getSelectedItem());

        String[] array = new String[returnList.size()];
        for (int i = 0; i < returnList.size(); i++) {
            array[i] = returnList.get(i).getShortDescription();
        }

        ArrayAdapter<String> donationAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item_1, array);
        donationList.setAdapter(donationAdapter);
        if (returnList.size() == 0) {
            message.setVisibility(View.VISIBLE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onSearchByName(View view) {
        message.setVisibility(View.GONE);
        returnList = donationItemsManager.searchByName((Location) locationSpinner.getSelectedItem(),
                name.getText().toString());

        String[] array = new String[returnList.size()];
        for (int i = 0; i < returnList.size(); i++) {
            array[i] = returnList.get(i).getShortDescription();
        }

        ArrayAdapter<String> donationAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item_1, array);
        donationList.setAdapter(donationAdapter);
        if (returnList.size() == 0) {
            message.setVisibility(View.VISIBLE);
        }
    }
}
