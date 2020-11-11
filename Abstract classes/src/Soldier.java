public abstract class Soldier {
    private String name;

    public Soldier(String name) {
        this.name = name;
    }

    public abstract void meleeAttack();
    public abstract void rangedAttack();

    public String getName() {
        return name;
    }
}
