package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryLocationsRepository implements LocationsRepository {
    private static final LocationsRepository instance = new InMemoryLocationsRepository();
    private Map<Integer, Location> locations;

    private InMemoryLocationsRepository() {
        locations = new HashMap<Integer, Location>();
    }

    public static LocationsRepository getInstance() {
        return instance;
    }

    public Location findById(int locationId) {
        return locations.get(locationId);
    }

    public void addLocation(Location location) {
        locations.put(location.id, location);
    }

    public void removeLocation(Location location) {

    }
}
