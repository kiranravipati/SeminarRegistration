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

    // implementation of interface methods
    @Override

    public Location findById(int locationId) {
        return locations.get(locationId);
    }

    public void addLocation(Location location) {
        locations.put(location.id, location);
    }

    public void createDefaultLocations() {
        Location location = new Location("Abdul Kalam", "First", 30, 1);
        addLocation(location);

        location = new Location("Einstein", "Second", 50, 2);
        addLocation(location);

        location = new Location("Newton", "Third", 40, 3);
        addLocation(location);
    }
}
