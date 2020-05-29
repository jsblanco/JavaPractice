package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de bytes: "+myMinByteValue +" y "+ myMaxByteValue);


        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de Shorts: "+myMinShortValue +" y "+ myMaxShortValue);


        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de integers: "+myMinIntValue +" y "+ myMaxIntValue);


        long number = 12284987322097L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de Long: "+myMinLongValue +" y "+ myMaxLongValue);

        byte halfMin = (byte) (myMinByteValue/2);
        short halfShort = (short) (myMaxShortValue/2);
        int halfInt = myMaxIntValue/2;

        short castingShorts = 1000+ 10*(47+315);
        System.out.println(castingShorts);

        long myTotalLong=  50000L+10L*(halfInt+halfShort+halfMin);
        System.out.println(myTotalLong);


        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de Float: "+myMinFloatValue +" y "+ myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Valores mínimos y maximos de Double: "+myMinDoubleValue +" y "+ myMaxDoubleValue);

        int intNumber = 5;
        float floatNumber = 5.25f;
        double doubleNumber = 5.25;

        float floatNum =5f;
        double doubleNum=5d;

        System.out.println(floatNum+" "+doubleNum);
        System.out.println(floatNum/2+" "+(doubleNum/2)+""+intNumber/2);//ints siempre redondean hacia abajo, nunca tienen comas

        int pounds = 180;
        double poundsInAKg = 0.45359237d;
        double kgs = pounds*poundsInAKg;

        System.out.println(kgs+" kgs in "+pounds+" pounds");
    }
}
