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

    public static DonationItemsManager getInstance() {
        return instance;
    }

    public List<DonationItem> getDonations() {
        return donations;
    }

    public void addDonation(String time, Location location, String shortDescription,
                            String fullDescription, String value, String category) {
        DonationItem donation = new DonationItem(time, location, shortDescription, fullDescription,
                value, category);
        donations.add(donation);
    }
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
    public void clearDonations() {
        donations.clear();
    }
}
