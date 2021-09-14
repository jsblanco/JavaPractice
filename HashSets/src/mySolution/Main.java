package mySolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, Planet> solarSystem = new HashMap<>();
    private static final Set<Planet> planets = new HashSet<>();
    private static final Set<Moon> moons = new HashSet<>();

    public static void main(String[] args) {
        populateSolarSystem();

        for (Planet planet : planets) moons.addAll(planet.getSatellites());

        Planet pluto = new Planet("Pluto", 842);
        planets.add(pluto);

        getPlanetsData();

        solarSystem.put(pluto.getName(), pluto);
        System.out.println(solarSystem.get(pluto.getName()).getOrbitalPeriod());

        Moon plutoMoon = new Moon("Pluto", 842);
        System.out.println(pluto.equals(plutoMoon));
    }

    public static void createNewPlanet(String name, double orbitalPeriod) {
        Planet planet = new Planet(name, orbitalPeriod);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);
    }

    public static void createNewSatellite(String name, double orbitalPeriod, String planetName) {
        Moon moon = new Moon(name, orbitalPeriod);
        solarSystem.get(planetName).addSatellite(moon);
    }

    public static void getPlanetsData() {
        System.out.println("Planets in the Solar System:");
        for (Planet planet : planets)
            if (planet.getSatellites().size() == 0)
                System.out.println("\t" + planet.getName() + ", with an orbital period of " + planet.getOrbitalPeriod() + " and no moons");
            else {
                System.out.println("\t" + planet.getName() + ", with an orbital period of " + planet.getOrbitalPeriod() + " and the following moons: ");
                for (Moon moon : planet.getSatellites())
                    System.out.println("\t\t" + moon.getName());
            }
        ;
    }

    public static void getMoonsData() {
        System.out.println("Moons in the Solar System:");
        for (Moon moon : moons)
            System.out.println("\t" + moon.getName());
    }

    private static void populateSolarSystem() {
        createNewPlanet("Mercury", 88);
        createNewPlanet("Venus", 225);
        createNewPlanet("Earth", 365);
        createNewPlanet("Mars", 687);
        createNewPlanet("Jupiter", 4332);
        createNewPlanet("Saturn", 10759);
        createNewPlanet("Uranus", 30660);
        createNewPlanet("Neptune", 165);
        createNewPlanet("Pluto", 248);

        createNewSatellite("Moon", 27, "Earth");
        createNewSatellite("Deimos", 1.3, "Mars");
        createNewSatellite("Phobos", 0.3, "Mars");
        createNewSatellite("Io", 1.8, "Jupiter");
        createNewSatellite("Europa", 3.5, "Jupiter");
        createNewSatellite("Ganymede", 7.1, "Jupiter");
        createNewSatellite("Callisto", 16.7, "Jupiter");
    }
}
// A diferencia del HashMap, un HashSet no tiene en cuenta el orden, y no permite entradas idénticas / repetidas.
// No hay forma de sacar una posición en particular de un set; se puede iterar, y ver si algo existe.
// Para sacar un valor de un set necesitaremos la key asociada.
