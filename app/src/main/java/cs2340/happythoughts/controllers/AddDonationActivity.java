package cs2340.happythoughts.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340.happythoughts.models.DonationItem;
import cs2340.happythoughts.models.DonationItemsManager;
import cs2340.happythoughts.models.Location;
import cs2340.happythoughts.R;

public class AddDonationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView time;
    private TextView shortDescription;
    private TextView fullDescription;
    private TextView value;
    private Spinner location;
    private Spinner itemType;
    private final DonationItemsManager donationItemsManager = DonationItemsManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        time = (EditText)findViewById(R.id.TimeStamp);
        shortDescription = (EditText)findViewById(R.id.ShortDescription);
        fullDescription = (EditText)findViewById(R.id.FullDescription);
        value = (EditText)findViewById(R.id.Value);
        location = findViewById(R.id.LocationSpinner);
        itemType = findViewById(R.id.ItemSpinner);
        Button add = findViewById(R.id.addDonation);
        Button cancel = findViewById(R.id.cancelDonation);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itemArray, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        itemType.setAdapter(adapter);
        itemType.setOnItemSelectedListener(this);

        ArrayAdapter<Location> adapter2 = new ArrayAdapter<>(this,
                R.layout.simple_spinner_item, MainActivity.getLocations());
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        location.setAdapter(adapter2);
        location.setOnItemSelectedListener(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonationItem item = new DonationItem(time.getText().toString(), (Location) location.getSelectedItem(), shortDescription.getText().toString(),
                        fullDescription.getText().toString(), value.getText().toString(),
                        itemType.getSelectedItem().toString());
                MainActivity.donationsList.add(item);
                donationItemsManager.getDonations().add(item);
                Intent intent = new Intent(AddDonationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDonationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}