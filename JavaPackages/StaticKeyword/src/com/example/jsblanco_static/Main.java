package com.example.jsblanco_static;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {

        StaticTest firstInstance = new StaticTest("Primera instancia");
        System.out.println(firstInstance.getName()+" es la instancia nº "+firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("Segunda instancia");
        System.out.println(secondInstance.getName()+" es la instancia nº "+secondInstance.getNumInstances());

        System.out.println("Número de instancias de la clase StaticTest: "+StaticTest.getNumInstances());

        int answer = multiply(6);
        System.out.println(answer);

        FinalVarClass one = new FinalVarClass("Primera");
        FinalVarClass two = new FinalVarClass("Segunda");
        FinalVarClass three = new FinalVarClass("Tercera");

        System.out.println("Número de instancia: "+one.getInstanceNumber() +", número de contador: "+FinalVarClass.getClassCounter());
        System.out.println("Número de instancia: "+two.getInstanceNumber()+", número de contador: "+FinalVarClass.getClassCounter());
        System.out.println("Número de instancia: "+three.getInstanceNumber()+", número de contador: "+FinalVarClass.getClassCounter());

        System.out.println(Math.PI);

        //Con el constructor en privado, no se pueden crear instancias de una clase.
        //Math vaADarError = New Math();
        //Además, como la clase está marcada como final, no se pueden hacer subclases.

        //Marcar métodos de una clase como Final impedirá que sean sobreescritos en subclases.
        FinalMethodsPassword password = new FinalMethodsPassword(16);
        password.storePassword();
        password.enterPassword(324);
        password.enterPassword(22);
        password.enterPassword(16);

        ExtendedPassword newPassword = new ExtendedPassword(16);
        newPassword.storePassword();
        newPassword.enterPassword(324);
        newPassword.enterPassword(22);
        newPassword.enterPassword(16);

        SIBtest test = new SIBtest();
        test.someMethod();
        System.out.println("El dueño es "+SIBtest.owner);


    }

    public static int multiply(int number){
        return number * multiplier;
    }
}
