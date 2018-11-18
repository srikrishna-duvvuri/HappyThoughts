package cs2340.happythoughts;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cs2340.happythoughts.models.DonationItem;
import cs2340.happythoughts.models.Location;

@RunWith(JUnit4.class)
public class AdeTest {

    private final Location newLoc = new Location(100, "GT", 19.11, 19.19,
            "123 GT Station", "Atla", "Ga", "30318", "type", "123-123-1234", "1234.com");

    @Test
    public void testDonationItem() {
        DonationItem items = new DonationItem("12", newLoc,
                "miscellaneous", "long description here", "worth-alot", "clothing");

        assertEquals("12", items.getTime());
        assertEquals(newLoc, items.getLocation());
        assertEquals("miscellaneous", items.getShortDescription());
        assertEquals("long description here", items.getFullDescription());
        assertEquals("worth-alot", items.getValue());
        assertEquals("clothing", items.getCategory());
    }

    @Test
    public void testDonationItemWithChanges() {

        DonationItem items = new DonationItem("12", newLoc,
                "miscellaneous", "long description here", "worth-alot", "clothing");

        Location oldLoc = new Location(50, "Tech", 30.1, 12.19,
                "12345 GT Station", "Atlanta", "GA", "30440", "type", "123-123-1234", "1234.com");

        items.setTime("11");
        items.setLocation(oldLoc);
        items.setShortDescription("Socks");
        items.setFullDescription("no description added");
        items.setValue("worth nothing");
        items.setCategory("toys");

        assertNotSame(12, items.getTime());
        assertNotSame(newLoc, items.getLocation());
        assertNotSame("miscellaneous", items.getShortDescription());
        assertNotSame("long description here", items.getFullDescription());
        assertNotSame("worth-alot", items.getValue());
        assertNotSame("clothing", items.getCategory());
    }
}