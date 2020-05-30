public class Fish extends Animal {

private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int weight, int size, int gills, int eyes, int fins) {
        super(name, 1, 1, weight, size, "pez");
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    public void swim(){
        moveBody();
        moveBackFin();
        super.move(20);
    }

    public void rest(){
        System.out.println(getName()+" descansa, porque es un "+getSpecies()+" y los peces no duermen.");
    }

    private void moveBackFin(){
        System.out.println("Then "+getName()+" starts swimming with his fins");
    }

    private void moveBody(){
        System.out.println(getName()+" starts twisting his body");
    }

    public static void drown(){
        System.out.println("Los peces se ahogan fuera del agua, no dentro");
    }

}
