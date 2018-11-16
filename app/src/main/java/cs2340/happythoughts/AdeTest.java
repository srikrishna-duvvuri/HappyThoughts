package cs2340.happythoughts;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import android.support.test.runner.AndroidJUnit4;
import android.os.SystemClock;

import cs2340.happythoughts.Models.DonationItem;
import cs2340.happythoughts.Models.DonationItemsManager;

public class AdeTest {

    @Test
    public void testDonationItem() {
        Location newLoc = new Location(100, "GT", 19.11, 19.19,
                "123 GT Station", "Atla", "Ga", "30318", "type", "123-123-1234", "1234.com");
        DonationItem items = new DonationItem(12, newLoc,
                "miscellaneous", "long description here", "worth-alot", "clothing");

        assertEquals(12, items.getTime());
        assertEquals(newLoc, items.getLocation());
        assertEquals("miscellaneous", items.getShortDescription());
        assertEquals("long description here", items.getLongDescription());
        assertEqauls("worth-alot", items.getValue());
        assertEquals("clothing", items.getCategory());
    }

    @Test
    public void testDonationItemWithChanges() {

        DonationItem items = new DonationItem(12, newLoc,
                "miscellaneous", "long description here", "worth-alot", "clothing");

        items.setTime(11);
        items.setLocation(oldLoc);
        items.setShortDescription("Socks");
        items.setLongDescription("no description added");
        items.setValue("worth nothing");
        items.setCategory("toys");

        assertNotSame(12, items.getTime());
        assertNotSame(newLoc, items.getLocation());
        assertNotSame("miscellaneous", items.getShortDescription());
        assertNotSame("long description here", items.getLongDescription());
        assertNotSame("worth-alot", items,getValue());
        assertNotSame("clothing", items.getCategory());
    }
}