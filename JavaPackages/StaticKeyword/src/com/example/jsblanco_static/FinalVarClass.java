package com.example.jsblanco_static;

public class FinalVarClass {

    private static int classCounter = 0;
    public final int instanceNumber;// = 1;
    public final  String name;

    public FinalVarClass(String name) {
        this.name= name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println("Se ha creado la clase "+this.name+", con número de instancia "+instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    public static int getClassCounter() {
        return classCounter;
    }
}
