public class DeathKorps extends Soldier implements IsLoyalToTheEmperor{

    public DeathKorps(String name) {
        super(name);
    }

    @Override
    public void meleeAttack() {
        System.out.println("Death Korps soldier "+getName()+" attacked with his shovel");
    }

    @Override
    public void rangedAttack() {
        System.out.println("Death Korps soldier "+getName()+" shot his lasgun");
    }

    @Override
    public void praiseTheEmperor() {
        System.out.println(getName()+" spouts 'The Emperor Protects!'");
    }
}
