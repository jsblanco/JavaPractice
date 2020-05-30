public class SecondaryChar {
    private String name;
    private int health;
    private int mana;
    private String weapon;

    public SecondaryChar(String name, int health, String weapon) {
        this.name = name;
        if (health>0 && health <=200) {
            this.health = health;
        } else {
            this.health = 100;
        };
        this.mana = 100;
        this.weapon = weapon;
    }

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



    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public String getWeapon() {
        return weapon;
    }
}
