package cs2340.happythoughts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import cs2340.happythoughts.models.Location;
import cs2340.happythoughts.models.LocationsManager;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

import java.util.List;

@RunWith(JUnit4.class)
public class JaradTest {

    private Location loc1;
    private Location loc2;
    private Location loc3;
    private LocationsManager locMan;
    @Before
    public void initialize() {
        loc1 = new Location(1,"one",33.7490,84.3880,"one way","onelanta","onegeorgia",
                "1zip","1type","1phone","1.com");
        loc2 = new Location(2,"two",39.8150,81.2260,"two way","twolanta","twogeorgia",
                "2zip","2type","2phone","2.com");
        loc3 = new Location(3,"three",44.2010,74.9200,"three way","threelanta","threegeorgia",
                "3zip","3type","3phone","3.com");
        locMan = LocationsManager.getInstance();
    }

    @Test
    public void checkLocationList() {
        locMan.addLocation(loc1);
        locMan.addLocation(loc2);
        locMan.addLocation(loc3);
        List<Location> locs = locMan.getLocations();
        assertEquals(loc1, locs.get(0));
        assertEquals(loc2, locs.get(1));
        assertEquals(loc3, locs.get(2));
    }

    @Test
    public void checkLocationListFailed() {
        locMan.clearLocations();
        locMan.addLocation(loc1);
        locMan.addLocation(loc2);
        locMan.addLocation(loc2);
        List<Location> locs = locMan.getLocations();
        assertEquals(loc1, locs.get(0));
        assertEquals(loc2, locs.get(1));
        assertNotSame(loc3, locs.get(2));
    }
}
