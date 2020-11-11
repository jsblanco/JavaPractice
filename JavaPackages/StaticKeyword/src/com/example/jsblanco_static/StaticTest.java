package com.example.jsblanco_static;

public class StaticTest {
    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public String getName() {
        return name;
    }

    public static int getNumInstances() {
        return numInstances;
    }
}
