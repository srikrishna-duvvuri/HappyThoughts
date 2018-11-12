package cs2340.happythoughts.Models;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DonationItemsManager {

    private static DonationItemsManager instance = new DonationItemsManager();

    private List<DonationItem> donations;
    private LocationsManager locationManager;


    private DonationItemsManager() {
        this.donations = new ArrayList<>();
        this.locationManager = LocationsManager.getInstance();
    }

//    private List<DonationItem> retrieveDonationItems() {
//        SharedPreferences mPrefs = getSharedPreferences("donationInfo", MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = mPrefs.getString("donations", "");
//        return (List<DonationItem>) gson.fromJson(json, List.class);
//    }

    public static DonationItemsManager getInstance() {
        return instance;
    }

    public List<DonationItem> getDonations() {
        return donations;
    }

    public void addDonation(String name, Location location, String value, String shortDescription,
                            String fullDescription, String category) {
        DonationItem donation = new DonationItem(name, location, value, shortDescription, fullDescription,
                category);
        donations.add(donation);
//        storeDonations();
    }

    public void addDonations(ArrayList<DonationItem> list) {
        for (DonationItem item : donations) {
            donations.add(item);
        }
    }

    public void setDonations(ArrayList<DonationItem> list) {
        donations = list;
    }

//    private void storeDonations() {
//        SharedPreferences mPrefs = getSharedPreferences("donationInfo", MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = mPrefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(donations);
//        prefsEditor.putString("donations", json);
//        prefsEditor.commit();
//    }

    @SuppressLint("NewApi")
    public ArrayList<DonationItem> search(Predicate<DonationItem> filter) {
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
}
