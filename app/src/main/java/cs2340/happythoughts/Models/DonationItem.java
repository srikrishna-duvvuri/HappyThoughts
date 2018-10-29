package cs2340.happythoughts.Models;

public class DonationItem {
    private String time;
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private String value;
    private String category;

    public DonationItem(String time, Location location, String shortDescription, String fullDescription, String value, String category) {
        this.time = time;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
