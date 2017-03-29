package rachelmiller.inclassassignment08_rachelm;

import java.io.Serializable;

/**
 * Created by rachelmiller on 3/28/17.
 */

public class Planet implements Serializable {
    private String planet;
    private int distance;
    private boolean hasWater;

    public Planet() {  // required for data read from Firebase

    }

    public Planet(String planet, int distance, boolean hasWater) {
        this.planet = planet;
        this.distance = distance;
        this.hasWater = hasWater;
    }

    public String getPlanet() {
        return planet;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    @Override
    public String toString() {
        return planet + " " + distance + " " + hasWater;
    }
}

