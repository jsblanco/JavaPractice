public class MainChar {
    public String name;
    private int health;
    private int mana;
    private String weapon;


    public void receiveDamage(int damage){
        if (this.health - damage >-1) {
            this.health -= damage;
            System.out.println(name+" ha recibido "+damage+" puntos de daño.");
            if (this.health <= 0) System.out.println("¡Has muerto!");
        }
        if (health == 0) System.out.println(name+" está muerto y enterrado.");
    }

    public void castFireball(){
        if (this.mana >9) {
            this.mana -= 10;
            System.out.println(name+" lanza una bola de fuego");
        };
        if (this.health <=0) System.out.println("¡"+name+" no tiene maná!");
    }

    public int playerHealth(){
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
