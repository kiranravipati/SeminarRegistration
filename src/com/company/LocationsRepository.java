package com.company;

public interface LocationsRepository {
    Location findById(int locationId);
    void addLocation(Location location);
    void createDefaultLocations();
}
