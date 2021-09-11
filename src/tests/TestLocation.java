package tests;

import common.Location;
import org.junit.Test;

public class TestLocation {
    @Test
    public void createLocation() {
        Location location = new Location(2, 3);
        assert location.getX() == 2;
        assert location.getY() == 3;
        location.setX(10);
        location.setY(2);
        assert location.getX() == 10;
        assert location.getY() == 2;
    }

}
