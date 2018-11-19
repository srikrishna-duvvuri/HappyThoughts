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

    /**
     * Gets instance of Locations Manager
     *
     * @return the instance
     */
    public static LocationsManager getInstance() {
        return instance;
    }

    /**
     * Returns the list of locations
     *
     * @return the list
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Adds to list of locations
     *
     * @param location location to add
     */
    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * Gets a location value that says "All Locations"
     *
     * @return the placeholder for all locations
     */
    public Location getAllLocation() {
        return allLocations;
    }

    /**
     * Clears the list of locations
     */
    public void clearLocations() {
        locations.clear();
    }
}