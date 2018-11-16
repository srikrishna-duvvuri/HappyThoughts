package cs2340.happythoughts.models;

import java.util.ArrayList;
import java.util.List;

public class LocationsManager {

    private static final LocationsManager instance = new LocationsManager();

    private final List<Location> locations;

    private static final Location allLocations = new Location(-1, "All Locations", 0, 0,
            "", "", "", "", null, "", "");

    private LocationsManager() {
        locations = new ArrayList<>();
    }

    public static LocationsManager getInstance() {
        return instance;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Location getAllLocation() {
        return allLocations;
    }
}