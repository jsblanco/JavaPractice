package com.timbuchalka;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {

        //Si la clase se llamase Map, podría inicializar esta variable como java.util.Map<String, String> Languages
        //para evitar que Java la confundiese con el nombre de la clase en general
        Map<String, String> languages = new HashMap<>();

        //Guardamos pares key-value usando Put
        languages.put("Español", "Lengua romance envidia del mundo");
        languages.put("Japonés", "Conocida como \"la Lengua del diablo\" por misioneros");
        languages.put("Alemán", "Lengua experta en transmitir la ira del hablante");
        languages.put("Inglés", "Lengua que desconoce lo que es la gramática");

        //Recuperamos un key-value usando Get
        System.out.println(languages.get("Español"));

        //Las keys son únicas, si hacemos PUT repetido lo que hacemos es sobreescribir la anterior
        languages.put("Español", "Tesoro de la raza humana, la lengua de los ángeles");
        System.out.println(languages.get("Español"));
    }
}
