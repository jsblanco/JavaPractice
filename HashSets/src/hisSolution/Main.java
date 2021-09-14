package hisSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static final Set<HeavenlyBody> planets = new HashSet<>();
    private static final Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {
        populateSolarSystem();
        getPlanetsData();

        for (HeavenlyBody planet: planets)
            moons.addAll(planet.getSatellites());

        getMoonsData();

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842, HeavenlyBody.BodyType.PLANET);
        planets.add(pluto);
        getPlanetsData();
    }

    public static void createNewPlanet(String name, double orbitalPeriod) {
        HeavenlyBody planet = new HeavenlyBody(name, orbitalPeriod, HeavenlyBody.BodyType.PLANET);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);
    }

    public static void createNewSatellite(String name, double orbitalPeriod, String planetName) {
        HeavenlyBody moon = new HeavenlyBody(name, orbitalPeriod, HeavenlyBody.BodyType.MOON);
        solarSystem.get(planetName).addSatellite(moon);
    }

    public static void getPlanetsData() {
        System.out.println("Planets in the Solar System:");
        for (HeavenlyBody planet : planets)
            if (planet.getSatellites().size() == 0)
                System.out.println("\t" + planet.getName() + ", with an orbital period of " + planet.getOrbitalPeriod() + " and no moons");
            else {
                System.out.println("\t" + planet.getName() + ", with an orbital period of " + planet.getOrbitalPeriod() + " and the following moons: ");
                for (HeavenlyBody moon : planet.getSatellites())
                    System.out.println("\t\t" + moon.getName());
            };
    }

    public static void getMoonsData() {
        System.out.println("Moons in the Solar System:");
        for (HeavenlyBody moon: moons)
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