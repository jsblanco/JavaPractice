public abstract class SpaceMarine extends Soldier implements IsLoyalToTheEmperor {
    boolean primaris;

    public SpaceMarine(String name) {
        super(name);
        this.primaris = false;
    }

    public SpaceMarine(String name, boolean primaris) {
        super(name);
        this.primaris = primaris;
    }

    public boolean isPrimaris(){
        return this.primaris;
    }

    public void rubiconPrimatis(){
        if (this.primaris){
            System.out.println(getName()+" is already a Primaris Marine");
        } else {
            this.primaris = true;
            System.out.println(getName()+" has survived the Rubicon and joined his Primaris brethren.");
        }
    }

    public abstract void chapterPrimarch();

    @Override
    public void meleeAttack() {
        System.out.println("Space marine "+getName()+" attacked with his chainsword");
    }

    @Override
    public void rangedAttack() {
        System.out.println("Space marine "+getName()+" shot his bolter");
    }


}
