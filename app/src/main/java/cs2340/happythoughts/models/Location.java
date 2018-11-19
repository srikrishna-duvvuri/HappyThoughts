package cs2340.happythoughts.models;

public class Location {
    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String type;
    private String phone;
    private String website;

    /**
     * Creates new Location
     */
    public Location() {
        //empty Location instance created
    }

    /**
     * Creates new location with given info
     *
     * @param key key
     * @param name name
     * @param latitude latitude
     * @param longitude longitude
     * @param streetAddress address line
     * @param city city line
     * @param state state line
     * @param zip zip code
     * @param type type
     * @param phone phone number
     * @param website website
     */
    public Location(int key, String name, double latitude, double longitude,
                    String streetAddress, String city, String state,
                    String zip, String type, String phone,
                    String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
    }

    /**
     * gets the key
     *
     * @return key
     */
    public int getKey() {
        return key;
    }

    /**
     * set the key
     *
     * @param key key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the latitude
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * set the latitude
     *
     * @param latitude latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * get the longitude
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * set the longitude
     *
     * @param  longitude longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * get the street address
     *
     * @return streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * set the street address
     *
     * @param streetAddress streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * get the city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set the city
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get the state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * set the state
     *
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * get the zip
     *
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * set the zip
     *
     * @param zip zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * get the type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * set the type
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get the phone number
     *
     * @return phone
     */
    public String getPhoneNumber() {
        return phone;
    }

    /**
     * set the phone number
     *
     * @param phoneNumber phone
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    /**
     * get the website
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * set the website
     *
     * @param  website site
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Location Name: " + name;
    }
}
