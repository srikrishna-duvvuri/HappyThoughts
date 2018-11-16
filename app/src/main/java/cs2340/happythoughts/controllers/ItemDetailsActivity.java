package cs2340.happythoughts.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.happythoughts.R;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        TextView donationLocation = findViewById(R.id.LocationDisplay);
        TextView donationShortD = findViewById(R.id.ShortDescriptionDisplay);
        TextView donationFullD = findViewById(R.id.LongDescriptionDisplay);
        TextView donationValue = findViewById(R.id.AmountDisplay);
        TextView donationTime = findViewById(R.id.TimeStampDisplay);
        TextView donationType = findViewById(R.id.TypeDisplay);

        donationLocation.setText("Location: " + getIntent().getStringExtra("location"));
        donationShortD.setText("Short Description: " + getIntent().getStringExtra("shortd"));
        donationFullD.setText("Full Description: " + getIntent().getStringExtra("fulld"));
        donationValue.setText("Value: " + getIntent().getStringExtra("value"));
        donationTime.setText("Time: " + getIntent().getStringExtra("time"));
        donationType.setText("Type: " + getIntent().getStringExtra("type"));




    }
}
