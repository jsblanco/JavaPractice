package hisSolution;

public class Sun extends HeavenlyBody {
    public Sun(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.STAR);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (!moon.getKey().getBodyType().equals(BodyTypes.MOON))
            return super.addSatellite(moon);
        return false;
    }
}
