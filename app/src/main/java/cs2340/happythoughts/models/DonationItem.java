package cs2340.happythoughts.models;

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

    /** Getter method for getting the time
     *
     * @return time at that point
     */
    public String getTime() {
        return time;
    }

    /** Setter method at that point
     *
     * @param time time at that point
     */
    public void setTime(String time) {
        this.time = time;
    }

    /** Getter method for getting the location
     *
     * @return location at that point
     */
    public Location getLocation() {
        return location;
    }

    /** Setter method for the location
     *
     * @param location location at that point
     */
    public void setLocation(Location location) {
        this.location = location;
    }


    /** Getter method for getting the short description
     *
     * @return short description at that point
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /** Setter method for setting Short Description
     *
     * @param shortDescription short description for the setting description
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /** Getter method for getting the full description
     *
     * @return full description at that point
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /** Setter method for setting Full Description
     *
     * @param fullDescription short description for the setting description
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /** Getter method for getting the value
     *
     * @return value at that point
     */
    public String getValue() {
        return value;
    }

    /** Setter method for setting value
     *
     * @param value setting the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** Getter method for getting the category
     *
     * @return category at that point
     */
    public String getCategory() {
        return category;
    }

    /** Setter method for setting category
     *
     * @param category setting the category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
