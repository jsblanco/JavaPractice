package com.example.jsblanco_static;

public class SIBtest {

    public static final String owner;

    static {
        owner = "Jorge";
        System.out.println("SIB es Static Initialisation Block.");
    }

    static {
        System.out.println("Segundo bloque de inicialización.");
    }

    public void someMethod(){
        System.out.println("Método someMethod invocado.");
    }

}
