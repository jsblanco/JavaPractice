public class Main {

    public static void main(String[] Args) {

        MainChar player = new MainChar();

        //El nombre es una variable Public así que lo podemos modificar sin problema.
        player.name= "Bernardo";
        //Los demás datos son Private, así que necesitamos usar setters u otro método.
        player.setHealth(100);
        player.setMana(100);
        player.setWeapon("Espada");

        int daño =25;

        player.receiveDamage(daño);
        //Como Name es público, puedo acceder como si fuese una key de un objeto
        System.out.println("Vida restante de "+player.name+": "+player.playerHealth());
        player.receiveDamage(daño);
        //Pero como Health es privado, necesito un getter u otro método para acceder
        System.out.println(player.playerHealth());
        player.receiveDamage(daño);
        System.out.println(player.playerHealth());
        player.receiveDamage(daño);
        System.out.println(player.playerHealth());

        SecondaryChar secondary = new SecondaryChar("Francisco", 150, "Maza");

        secondary.receiveDamage(daño);
        System.out.println(secondary.getHealth());


        System.out.println("###################### Printer Challenge #######################");


        Printer printer = new Printer(10, true);
        Printer printer2 = new Printer(10, false);
        System.out.println("Total amount of pages printed between both printers: "
                + (printer.printPages(5) + printer2.printPages(5)));
        printer.addToner(80);
        printer.addToner(-20);

    }

}
