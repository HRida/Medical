package com.example.ousama.medical;

/**
 * Created by ousama on 1/19/2017.
 */

public class Locations {
    private double lon;
    private double lat;

    public Locations(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}
