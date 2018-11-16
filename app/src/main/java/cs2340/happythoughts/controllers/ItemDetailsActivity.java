package cs2340.happythoughts.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.happythoughts.R;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView donationLocation;
    private TextView donationShortD;
    private TextView donationFullD;
    private TextView donationValue;
    private TextView donationTime;
    private TextView donationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        donationLocation = findViewById(R.id.LocationDisplay);
        donationShortD = findViewById(R.id.ShortDescriptionDisplay);
        donationFullD = findViewById(R.id.LongDescriptionDisplay);
        donationValue = findViewById(R.id.AmountDisplay);
        donationTime = findViewById(R.id.TimeStampDisplay);
        donationType = findViewById(R.id.TypeDisplay);

        donationLocation.setText("Location: " + getIntent().getStringExtra("location"));
        donationShortD.setText("Short Description: " + getIntent().getStringExtra("shortd"));
        donationFullD.setText("Full Description: " + getIntent().getStringExtra("fulld"));
        donationValue.setText("Value: " + getIntent().getStringExtra("value"));
        donationTime.setText("Time: " + getIntent().getStringExtra("time"));
        donationType.setText("Type: " + getIntent().getStringExtra("type"));




    }
}
