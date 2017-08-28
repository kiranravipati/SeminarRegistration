
package com.company;

import java.util.ArrayList;

public interface LocationsRepository {
    public Location findById(int locationId);
    public void addLocation(Location location);
    public void removeLocation(Location location);
}
