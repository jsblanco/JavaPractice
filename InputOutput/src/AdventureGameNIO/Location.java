package AdventureGameNIO;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Location implements Serializable {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;
    private final long serialVersionUID = 1L;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        this.exits = exits == null ? new LinkedHashMap<>() : new LinkedHashMap<>(exits);
        this.exits.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }

    protected void addExit(String direction, int location){
        exits.put(direction, location);
    }
}
