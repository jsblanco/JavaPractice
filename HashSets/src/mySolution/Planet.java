package mySolution;

import java.util.HashSet;
import java.util.Set;

public final class Planet extends HeavenlyBody {
    private final Set<Moon> satellites;

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
        this.satellites = new HashSet<>();
    }

    public boolean addSatellite(Moon moon) { return this.satellites.add(moon);}

    public Set<Moon> getSatellites() { return new HashSet<>(this.satellites);}
}
