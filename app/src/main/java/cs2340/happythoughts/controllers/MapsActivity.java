package cs2340.happythoughts.controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

import cs2340.happythoughts.models.Location;
import cs2340.happythoughts.models.LocationsManager;
import cs2340.happythoughts.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private final LocationsManager locationsManager = LocationsManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Objects.requireNonNull(mapFragment).getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng atlantaCoordinates = new LatLng(33.7490, -84.3880);

        for (Location location : locationsManager.getLocations()) {
            LatLng locationCoordinates = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions locationMarker = new MarkerOptions().position(locationCoordinates).title(location.getName()).snippet(location.getPhoneNumber());
            googleMap.addMarker(locationMarker);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(locationCoordinates));
        }
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(10f));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(atlantaCoordinates));
    }
}
