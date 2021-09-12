import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() { return name; }

    public double getOrbitalPeriod() { return orbitalPeriod; }

    public boolean addSatellite(HeavenlyBody moon) { return this.satellites.add(moon);}

    public Set<HeavenlyBody> getSatellites() { return new HashSet<>(this.satellites);}


//    Hacemos override del método equals para que, al añadir dos planetas con el mismo nombre a un set, solo quede uno.
//    Al hacer este override, debemos asegurarnos de cubrir todas las casuísticas, no solo la de dos HeavenlyObjects.
//    Sin embargo, hasta que no anulemos el HashCode no lograremos que funcione.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        System.out.println("obj.getClass is "+obj.getClass());
        System.out.println("this.getClass is "+this.getClass());

        if (obj == null || (obj.getClass() != this.getClass())) return false;

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

//    Al anular el hashcode original podemos definir una comparación diferente y personalizada.
//    Ahora, como ambos objetos tendrán el mismo hashCode, Java usará el método equals() que anulamos previamente.
//    Aún así hay que tener cuidado, ya que ahora comparar un HeavenlyObject con la string de su nombre daría true!
    @Override
    public int hashCode() {
//        System.out.println("Comparando hashCodes.");
        return this.name.hashCode()+57;
    }
}
