package hisSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static final Set<HeavenlyBody> planets = new HashSet<>();
    private static final Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {
        populateSolarSystem();

        getPlanetsData();
        getMoonsData();

        testSymmetry();
        testMapSubstitution();

        getSolarSystemData();
    }

    public static void createNewPlanet(String name, double orbitalPeriod) {
        Planet planet = new Planet(name, orbitalPeriod);
        solarSystem.put(HeavenlyBody.makeKey(name, HeavenlyBody.BodyTypes.PLANET), planet);
        planets.add(planet);
    }

    public static void createNewSatellite(String name, double orbitalPeriod, String planetName) {
        Moon moon = new Moon(name, orbitalPeriod);
        solarSystem.put(HeavenlyBody.makeKey(name, HeavenlyBody.BodyTypes.PLANET), moon);
        solarSystem.get(HeavenlyBody.makeKey(planetName, HeavenlyBody.BodyTypes.PLANET)).addSatellite(moon);
        moons.add(moon);
    }

    public static void getSolarSystemData() {
        System.out.println("Solar System heavenly objects:");
        for (HeavenlyBody object : solarSystem.values())
            System.out.println("\t" + object);
    }

    public static void getPlanetsData() {
        System.out.println("Planets in the Solar System:");
        for (HeavenlyBody planet : planets)
            System.out.println("\t" + planet);
    }

    public static void getMoonsData() {
        System.out.println("Moons in the Solar System:");
        for (HeavenlyBody moon : moons)
            System.out.println("\t" + moon.getKey().getName());
    }

    private static void testSymmetry() {
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        HeavenlyBody moon = new Moon("Moon", 27);

        System.out.println();
        System.out.print("Equal HeavenlyObjects are identified as such: " + (earth1.equals(earth2) && earth2.equals(earth1)));

        System.out.println();
        System.out.println("Different HeavenlyObjects should be distinguished: " + (!earth1.equals(moon) && !moon.equals(earth1)));

    }

    private static void testMapSubstitution() {
        createNewPlanet("Pluto", 248);
        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(
                "Pluto should appear both as a planet and as a dwarf planet: "
                        + solarSystem.get(HeavenlyBody.makeKey(pluto.getKey().getName(), HeavenlyBody.BodyTypes.PLANET))
                        + " "
                        + solarSystem.get(HeavenlyBody.makeKey(pluto.getKey().getName(), HeavenlyBody.BodyTypes.DWARF_PLANET)));

        pluto = new Planet("Pluto", 842);
        solarSystem.put(pluto.getKey(), pluto);
        System.out.println("Pluto's orbital period should be 842: " + solarSystem.get(HeavenlyBody.makeKey(pluto.getKey().getName(), HeavenlyBody.BodyTypes.PLANET)));
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