public class Dog extends Animal{

    private String breed;
    private int eyes;
    private int legs;
    private int tail;
    private String coat;

    public Dog(String name, int weight, int size, String breed, int eyes, int legs, int tail, String coat) {
        super(name, 1, 1, weight, size, "perro");
        this.breed = breed;
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.coat = coat;
    }

    public void bark(){
        System.out.println(getName()+" el "+getSpecies()+" "+breed+" dice: Guau guau motherfucker");
    }

    @Override
    public void eat(){
        System.out.println(getName()+" el "+getSpecies()+" "+breed+" come comida de perro porque es un perro");
    }

    public void walk(){
        System.out.println(getName()+" el "+getSpecies()+" camina alegremente");
        super.move(10);
    }

    public void run(){
        System.out.println(getName()+" el "+getSpecies()+" corre como un cabrón");
        move(30);
    }

    @Override
    public void move(int speed) {
        System.out.println("Con sus "+legs+" patas moviéndose a toda velocidad, "+getName()+" alcanza los "+speed+" km/h");
    }
}
