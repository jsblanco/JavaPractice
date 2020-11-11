public class FireWarrior extends Soldier {

    public FireWarrior(String name) {
        super(name);
    }

    @Override
    public void meleeAttack() {
        System.out.println(getName()+" dies because he is a wimp.");
    }

    @Override
    public void rangedAttack() {
        System.out.println(getName()+" shoots his pulse blaster");
    }
}
