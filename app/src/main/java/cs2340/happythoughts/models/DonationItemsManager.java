package cs2340.happythoughts.models;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DonationItemsManager {

    private static final DonationItemsManager instance = new DonationItemsManager();

    private final List<DonationItem> donations;
    private final LocationsManager locationManager;


    private DonationItemsManager() {
        this.donations = new ArrayList<>();
        this.locationManager = LocationsManager.getInstance();
    }

    /** Getter method for instance
     *
     * @return instance at that point
     */
    public static DonationItemsManager getInstance() {
        return instance;
    }

    /** Getter method for donations
     *
     * @return donations at that point
     */
    public List<DonationItem> getDonations() {
        return donations;
    }

    /**Adds a donation to the list
     *
     * @param donation the donation to be added
     */
    public void addDonation(DonationItem donation) {
        donations.add(donation);
    }

    @SuppressLint("NewApi")
    private ArrayList<DonationItem> search(Predicate<DonationItem> filter) {
        ArrayList<DonationItem> result = new ArrayList<>();
        for (DonationItem donation : this.donations) {
            if (filter.test(donation)) {
                result.add(donation);
            }
        }
        return result;
    }

    /** search category method
     *
     * @param location location that is used to search by category
     * @param category category that is used to search by category
     * @return the array list of donations
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<DonationItem> searchByCategory(final Location location, final Category category) {
        if (location.equals(locationManager.getAllLocation())) {
            return search(new Predicate<DonationItem>() {
                @Override
                public boolean test(DonationItem donation) {
                    return donation.getCategory().equals(category.toString());
                }
            });
        } else {
            return search(new Predicate<DonationItem>() {
                @Override
                public boolean test(DonationItem donation) {
                    return donation.getLocation().toString().equals(location.toString()) && donation.getCategory().equals(category.toString());
                }
            });
        }
    }

    /** search category method
     *
     * @param location location that is used to search by category
     * @param name name that is used to search by category
     * @return the array list of donations
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<DonationItem> searchByName(final Location location, final String name) {
        if (location.equals(locationManager.getAllLocation())) {
            return search(new Predicate<DonationItem>() {
                @Override
                public boolean test(DonationItem donation) {
                    return donation.getShortDescription().equals(name);
                }
            });
        } else {
            return search(new Predicate<DonationItem>() {
                @Override
                public boolean test(DonationItem donation) {
                    return donation.getLocation().toString().equals(location.toString()) && donation.getShortDescription().equals(name);
                }
            });
        }
    }

    /** Clears the donations
     *
     */
    public void clearDonations() {
        donations.clear();
    }
}
