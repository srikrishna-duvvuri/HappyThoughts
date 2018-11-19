package cs2340.happythoughts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotSame;

import cs2340.happythoughts.models.Category;
import cs2340.happythoughts.models.Location;
import cs2340.happythoughts.models.DonationItem;
import cs2340.happythoughts.models.DonationItemsManager;

import java.util.List;

@RunWith(JUnit4.class)
public class SabrinaTest {

    private Location location1;
    private Location location2;
    private Location location3;
    private DonationItem donation1;
    private DonationItem donation2;
    private DonationItem donation3;
    private DonationItemsManager donationManager;

    @Before
    public void initialize() {
        location1 = new Location(1, "GT1", 19.11, 19.19,
                "1 GT Station", "Atla1", "Ga1", "30001", "type1",
                "123-123-1234", "1.com");
        location2 = new Location(2, "GT2", 20.12, 20.32,
                "2 GT Station", "Atla2", "Ga2", "30002", "type2",
                "234-567-890", "2.com");
        location3 = new Location(3, "GT3", 21.13, 21.43,
                "3 GT Station", "Atla3", "Ga3", "30003", "type3",
                "345-678-901", "3.com");
        donation1 = new DonationItem("1", location1,"miscellaneous1",
                "long description here1", "worth-alot1", "Clothing");
        donation2 = new DonationItem("2", location2, "miscellaneous2",
                "long description here2", "worth-alot2", "Baby");
        donation3 = new DonationItem("3", location3, "miscellaneous3",
                "long description here3", "worth-alot3", "Toys");
        donationManager = DonationItemsManager.getInstance();
    }

    @Test
    public void testDonationItemsManagerSuccess(){
        donationManager.addDonation(donation1);
        donationManager.addDonation(donation2);
        donationManager.addDonation(donation3);
        List<DonationItem> don = donationManager.getDonations();
        assertEquals(donation1, don.get(0));
        assertEquals(donation2, don.get(1));
        assertEquals(donation3, don.get(2));
        assertEquals(donation1, donationManager.searchByCategory(location1, Category.CLOTHING).get(0));
        assertEquals(donation2, donationManager.searchByCategory(location2, Category.BABY).get(0));
        assertEquals(donation3, donationManager.searchByCategory(location3, Category.TOYS).get(0));
    }

    @Test
    public void testDonationItemsManagerFail(){
        donationManager.clearDonations();
        donationManager.addDonation(donation1);
        donationManager.addDonation(donation2);
        donationManager.addDonation(donation3);
        List<DonationItem> don = donationManager.getDonations();
        assertEquals(donation1, don.get(0));
        assertEquals(donation2, don.get(1));
        assertNotSame(donation3, don.get(2));
        assertEquals(donation1, donationManager.searchByCategory(location1, Category.CLOTHING).get(0));
        assertEquals(donation2, donationManager.searchByCategory(location2, Category.BABY).get(0));
        assertNotSame(donation3, donationManager.searchByCategory(location3, Category.TOYS).get(0));
    }
}
