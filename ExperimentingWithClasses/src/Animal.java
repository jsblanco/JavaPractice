public class Animal {

    private String name;
    private int brain;
    private int body;
    private int weight;
    private int size;
    private String species;

    public Animal(String name, int brain, int body, int weight, int size, String species) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.weight = weight;
        this.size = size;
        this.species = species;
    }

    public void eat(){
        System.out.println(this.name+" el "+this.species+" está comiendo: ñom ñom");
    }

    public void move(int speed){
        System.out.println(this.name+" el "+this.species+" se mueve a "+speed+" kms/h");
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }
}
