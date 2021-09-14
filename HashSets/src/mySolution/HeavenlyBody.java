package mySolution;

public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        System.out.println("obj.getClass is " + obj.getClass() + " while this.getClass is " + this.getClass());

        if (obj == null || (obj.getClass() != this.getClass())) return false;

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }
}
