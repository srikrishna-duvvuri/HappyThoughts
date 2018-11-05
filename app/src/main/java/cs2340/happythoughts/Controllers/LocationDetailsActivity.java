package cs2340.happythoughts.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cs2340.happythoughts.Models.DonationItem;
import cs2340.happythoughts.R;

public class LocationDetailsActivity extends AppCompatActivity {

    private TextView locationTitle;
    private TextView locationType;
    private TextView locationCoordinates;
    private TextView locationAddress;
    private TextView locationPhone;
    private ListView donationList;

    public ArrayList<DonationItem> localItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        locationTitle = findViewById(R.id.locationNameText);
        locationType = findViewById(R.id.typeText);
        locationCoordinates = findViewById(R.id.coordinatesText);
        locationAddress = findViewById(R.id.addressText);
        locationPhone = findViewById(R.id.phoneText);
        donationList = findViewById(R.id.ListItems);

        Intent intent = getIntent();
        locationTitle.setText(intent.getStringExtra("name"));
        locationType.setText(intent.getStringExtra("type"));
        locationCoordinates.setText(intent.getStringExtra("coordinates"));
        locationAddress.setText(intent.getStringExtra("address"));
        locationPhone.setText(intent.getStringExtra("phone"));

        localItems = new ArrayList<>();

        for (int i = 0; i < MainActivity.donationsList.size(); i++) {
            if (TextUtils.equals(MainActivity.donationsList.get(i).getLocation().getName(), intent.getStringExtra("name"))) {
                localItems.add(MainActivity.donationsList.get(i));
            }
        }

        String[] array = new String[localItems.size()];

        for (int i = 0; i < localItems.size(); i++) {
            array[i] = localItems.get(i).getShortDescription();
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.simple_list_item_1, array);
        donationList.setAdapter(adapter);

        donationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ItemDetailsActivity.class);
                intent.putExtra("location", localItems.get(position).getLocation().getName());
                intent.putExtra("shortd", localItems.get(position).getShortDescription());
                intent.putExtra("fulld", localItems.get(position).getFullDescription());
                intent.putExtra("value", localItems.get(position).getValue());
                intent.putExtra("time", localItems.get(position).getTime());
                intent.putExtra("type", localItems.get(position).getCategory());
                startActivity(intent);
            }
        });
    }
}
