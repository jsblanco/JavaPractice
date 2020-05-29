public class Main {

    public static void main(String[] args) {
        Witcher firstWitcher= new Witcher();
        Witcher secondWitcher = new Witcher();
        Witcher thirdWitcher = new Witcher();

        firstWitcher.setData("Geralt", "Wolf", "Roach", 2, 10);
        firstWitcher.printWitcherData();
        secondWitcher.setData("vladimIR", "CAT", "DumbASs", 2, 15);
        secondWitcher.printWitcherData();
        thirdWitcher.setData("lambeRT", "Eagle", "Night maRe", 2, 5);
        thirdWitcher.printWitcherData();


        BankAccount myAccount = new BankAccount();

        myAccount.setData("Jorge Sánchez Blanco", "jorgesanchezblanco@hotmail.es", 695444721);
        myAccount.modifyFunds(4_000_000);
        System.out.println(myAccount.modifyFunds(-2_532.5));
        myAccount.getData();
    }
}
