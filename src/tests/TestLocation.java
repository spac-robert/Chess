package tests;

import common.Location;

public class TestLocation {
    private void createLocation() {
        Location location = new Location(2, 3);
        assert location.getX() == 2;
        assert location.getY() == 3;
        location.setX(10);
        location.setY(2);
        assert location.getX() == 10;
        assert location.getY() == 2;
    }

    public void runTestLocation() {
        this.createLocation();
    }
}
