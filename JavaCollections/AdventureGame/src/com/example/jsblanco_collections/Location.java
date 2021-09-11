package com.example.jsblanco_collections;

import java.util.HashMap;
import java.util.Map;

// La clase es final para evitar crear subclases con las que acceder a los elementos que queremos mantener inmutables
public final class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
//      Creamos un hashmap nuevo para evitar vincular el de la clase al contenido en la variable usada en su creación.
//      De no hacerlo, modificar esa variable causaría modificaciones en esta clase, al ser el mismo Map en la memoria.
//      Similar a, en TS, usar el spread op. para evitar mutabilidad en objetos y arrays.
//      Null es un Map, pero dará error al compilar, así que debemos asegurarnos de que no se asigna a Exits.
        this.exits = exits == null ? new HashMap<>() : new HashMap<>(exits);
//      Como todas las locations tendrán esta salida, la añadimos en el constructor para ahorrar código y evitar problemas.
        this.exits.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
//      El hashMap exits solo puede modificarse dentro de la clase. Eso puede ser un problema para el programa.
//      Devolvemos una copia del map para que otras funciones lo puedan modificar sin que puedan alterar el original.
        return new HashMap<>(exits);
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }
}
