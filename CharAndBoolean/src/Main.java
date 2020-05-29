public class Main {

    public static void main(String[] args) {

        char charmander = 'e';
        char charChungo = '\u3A34';
        System.out.print(charChungo);

        boolean caca = true;
        System.out.println(caca);
        System.out.println("hola");

        String cipote = "cipote! "+charChungo+" yeeeha!";

        if (!caca || charmander == 'e'){
            System.out.println(cipote);
        } else if (!!caca){
            System.out.println("oyoyoy");
        } else {
            System.out.println("Mecachis");
        }

        double firstDouble = 20.00d;
        double secondDouble = 80.00d;
        double result = (firstDouble+secondDouble)*100.00d;
        double remainder = result%40.00d;
        boolean isThereNoRemainder = remainder == 0;
        System.out.println("Is there no remainder? "+isThereNoRemainder+"; remainder is: "+remainder);
        if (!isThereNoRemainder){
            System.out.println("Got some remainder boss! ");
        }





}}
