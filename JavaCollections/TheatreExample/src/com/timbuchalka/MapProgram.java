package com.timbuchalka;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {

        //Si la clase se llamase Map, podría inicializar esta variable como java.util.Map<String, String> Languages
        //para evitar que Java la confundiese con el nombre de la clase en general
        Map<String, String> languages = new HashMap<>();
        //Guardamos pares key-value usando Put
        languages.put("Japonés", "Conocida como \"la Lengua del diablo\" por misioneros");
        languages.put("Alemán", "Lengua experta en transmitir la ira del hablante");
        languages.put("Inglés", "Lengua que desconoce lo que es la gramática");
        //Añadir un nuevo par no devuelve nada con SOUT
        System.out.println( languages.put("Español", "Lengua romance envidia del mundo") );
        //Recuperamos un key-value usando Get
        System.out.println(languages.get("Español"));
        //Las keys son únicas, si hacemos PUT repetido lo que hacemos es sobreescribir la anterior
        //Haciendo SOUT a este segundo put en lugar de Null nos devuelve el value sustituido.
        System.out.println( languages.put("Español", "Tesoro de la raza humana, la lengua de los ángeles"));
        System.out.println(languages.get("Español"));
        //con .containsKey podemos ver si una key existe antes de operar con ella
        if (languages.containsKey("Francés")){
            System.out.println("El francés ya está incluido en esta colección");
        } else {
            languages.put("Francés", "Lengua perfecta para hacer una cena de picoteo");
        }
        System.out.println(languages.get("Francés"));

        //Para eliminar tenemos .remove().
        //Podemos eliminar basándonos en la key:
        languages.remove("Inglés");
        System.out.println(languages.get("Inglés"));
        //O en un par key-value; solamente lo eliminará si ambos son correctos:
        languages.remove("Japonés", "La lengua de los mangas");
        System.out.println(languages.get("Japonés"));
        //languages.remove("Japonés", "Conocida como \"la Lengua del diablo\" por misioneros");
        //System.out.println(languages.get("Japonés"));

        //.replace() permite sustituir claves si existen
        languages.replace("Japonés", "Yare yare daze, nigerundayo!");
        languages.replace("Árabe", "La lengua del príncipe Alí Abaua");


        System.out.println("#######################################################");
        //keySet() nos devuelve todas las keys
        System.out.println(languages.keySet());
        for( String key : languages.keySet()){
            System.out.println("\033[0;1m"+key+": \033[0m"+languages.get(key));
        }
    }
}
