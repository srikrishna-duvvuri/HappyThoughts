package cs2340.happythoughts;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


import cs2340.happythoughts.Models.Location;

public class ChrisTest {
    @Test
    public void testLocationCreation() {

        Location newLoc = new Location(100, "Ga Tech", 21, 21,
                "12345 Georgia Tech Station", "Atlanta", "Georgia", "30332", "type", "123-123-1234", "1234.com");

        assertEquals(100, newLoc.getKey());
        assertEquals("Ga Tech", newLoc.getName());
        assertEquals(21.0, newLoc.getLatitude());
        assertEquals(21.0, newLoc.getLongitude());
        assertEquals("12345 Georgia Tech Station", newLoc.getStreetAddress());
        assertEquals("Atlanta", newLoc.getCity());
        assertEquals("Georgia", newLoc.getState());
        assertEquals("30332", newLoc.getZip());
        assertEquals("type", newLoc.getType());
        assertEquals("123-123-1234", newLoc.getPhoneNumber());
        assertEquals("1234.com", newLoc.getWebsite());
    }

    @Test
    public void testLocationCreationWithChanges() {

        Location newLoc = new Location(100, "Ga Tech", 21, 21,
                "12345 Georgia Tech Station", "Atlanta", "Georgia", "30332", "type", "123-123-1234", "1234.com");

        newLoc.setKey(50);
        newLoc.setName("UGA");
        newLoc.setCity("Athens");
        newLoc.setPhoneNumber("321-321-4321");
        newLoc.setType("trash");

        assertNotSame(100, newLoc.getKey());
        assertNotSame("Ga Tech", newLoc.getName());
        assertNotSame("Atlanta", newLoc.getCity());
        assertNotSame("123-123-1234", newLoc.getPhoneNumber());
        assertNotSame("type", newLoc.getType());
    }
}
