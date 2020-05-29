public class Main {

    public static void main(String[] args) {
        Witcher firstWitcher = new Witcher();
        Witcher secondWitcher = new Witcher();
        Witcher thirdWitcher = new Witcher();

        firstWitcher.setData("Geralt", "Wolf", "Roach", 2, 10);
        firstWitcher.printWitcherData();
        secondWitcher.setData("vladimIR", "CAT", "DumbASs", 2, 15);
        secondWitcher.printWitcherData();
        thirdWitcher.setData("lambeRT", "Eagle", "Night maRe", 2, 5);
        thirdWitcher.printWitcherData();


        BankAccount myAccount = new BankAccount("Jorge Sánchez Blanco", "jorgesanchezblanco@hotmail.es", 695444721, 2000000);
        //myAccount.modifyFunds(4_000_000);
        System.out.println(myAccount.modifyFunds(-2_532.5));
        myAccount.getData();

        BankAccount anonAccount = new BankAccount();
        anonAccount.getData();

        Animal gamusino = new Animal("Federico", 1, 1, 15, 3, "gamusino");

        Dog atila = new Dog("Atila", 15, 50, "Cavalier", 2, 4, 1, "tricolor suave");
        Fish merluzo = new Fish("Merluzo", 4, 8, 2, 2, 5);

        gamusino.eat();
        atila.eat();
        atila.bark();
        merluzo.rest();
        gamusino.move(4);
        atila.walk();
        atila.run();
        merluzo.swim();

    }
}
