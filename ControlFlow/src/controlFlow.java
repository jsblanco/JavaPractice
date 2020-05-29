public class controlFlow {
        public static void main(String[] args) {

            int variable = 50;

            switch (variable) {
                case 20:
                    System.out.println("20");
                    break;
                case 50:
                    System.out.println("50");
                    break;
                case 80:
                case 70:
                case 60:
                    System.out.println("Value is" + variable);
                    break;
                default:
                    System.out.println("default");
                    break;

            }

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }

            while (variable < 55) {
                variable++;
                System.out.println(variable);
            }


            do {
                variable += 200;
                System.out.println(variable);
            } while (variable < 20);


            String jorge = "Jorge mola";

            System.out.println(jorge + " " + jorge.toLowerCase() + " " + jorge.toUpperCase() + " " + jorge.substring(1, 3));
            System.out.println(jorge.split(" "));

        for (int i=2; i<9; i++){
            System.out.println("10.000 a un interés del "+i+"% es: "+String.format("%.2f",calculandoNos(10000.0,i)));
        }
        //el string format %.2f nos limita el número de decimales del resultado a 2
            System.out.println("#################");
            int count = 0;
            int aggregate = 0;

            for (int i=0; count <5;i++) {
            if ((i%3==0) && (i%5==0)){
                System.out.println(i);
                aggregate+=i;
                count++;
            }
            if (count == 5) System.out.println(aggregate);
            }

            System.out.println("Sum of numbers: "+ sumOfNumbers(125));

            String numberAsString="38383";
            System.out.println(numberAsString);
            System.out.println(Integer.parseInt(numberAsString));
            System.out.println(Double.parseDouble(numberAsString));




        }

public static int sumOfNumbers(int number){
            if (number <10) return -1;
            int sum =0;
            while (number>0){
                int digit  = number%10;
                sum += digit;
                number/=10;
            }
            return sum;
}

    public static double calculandoNos(double valor,double interes){
                return (valor*(interes/100));
            }


}
