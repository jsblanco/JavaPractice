package com.example.jsblanco_collections;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        this.addExit("Q", 0);
    }

    public void addExit(String direction, int location){
        exits.put(direction, location);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //El hashMap exits solo puede modificarse dentro de la clase. Eso puede ser un problema para el programa.
        //Devolvemos una copia del map, no el map en sí, para permitir que otras funciones lo puedan modificar
        return new HashMap<String, Integer>(exits);
    }
}
