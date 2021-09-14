package hisSolution;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public enum BodyType {
        STAR,
        PLANET,
        MOON,
        COMET,
        ASTEROID,
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;

        System.out.println("obj.getClass is " + obj.getClass() + " while this.getClass is " + this.getClass());

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody object = (HeavenlyBody) obj;
            if (this.name.equals(object.getName()))
                return this.bodyType == object.getBodyType();
            return false;
        }


        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}