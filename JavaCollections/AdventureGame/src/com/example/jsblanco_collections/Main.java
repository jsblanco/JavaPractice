package com.example.jsblanco_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static final Map<String, String> vocabulary = new HashMap<String, String>();
    private static int loc;

    public static void main(String[] args) {
        populateLocations();
        populateVocabulary();

        initialWelcome();

        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            stateExits(exits);

            String direction = getDirection();
            changeLocation(exits, direction);
        }
    }

    private static void initialWelcome() {
        loc = 1;

        //El método split() es como en JS; si pones unas comillas vacías te parte la string por caracteres.
        String[] welcome = "¡Bienvenido a Kamurocho!<br>Comienza a explorar sus calles.".split("<br>");
        for (String string : welcome) {
            System.out.println(string);
        }
    }

    private static void stateExits(Map<String, Integer> exits) {
        System.out.println("De aquí puedes ir a: ");
        for (String exit : exits.keySet())
            System.out.print(exit + ", ");
        System.out.println();
    }

    private static void changeLocation(Map<String, Integer> exits, String direction) {
        if (exits.containsKey(direction))
            loc = exits.get(direction);
        else
            System.out.println("No puedes ir ahí.");
    }

    private static String getDirection() {
        Scanner scanner = new Scanner(System.in);

/*
        String[] input = scanner.nextLine().toUpperCase().split(" ");
        char direction = input[input.length - 1].charAt(0);
        return String.valueOf(direction);
*/

        String direction = scanner.nextLine().toUpperCase();
        if (direction.length() > 1) {
            String[] inputWords = direction.split(" ");
            for (String word : inputWords) {
                if (vocabulary.containsKey(word)) {
                    direction = vocabulary.get(word);
                    break;
                }
            }
        }
        return direction;
    }

    private static void populateLocations() {
        locations.put(0, new Location(0, "Te vas de Kamurocho por el arco de Tenkaichi St."));
        locations.put(1, new Location(1, "Estás en la azotea de la Millenium Tower"));
        locations.put(2, new Location(2, "Estás en el Sega de Theatre Sq. jugando a MesuKing"));
        locations.put(3, new Location(3, "Estás en Earth Angel tomándote un copazo"));
        locations.put(4, new Location(4, "Estás en Don Quijote, cantando la musiquilla"));
        locations.put(5, new Location(5, "Estás en Kamurocho Hills, en la planta baja"));

        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("W", 2);
        // locations.get(1).addExit("Q", 0);
        locations.get(2).addExit("N", 5);
        //locations.get(2).addExit("Q", 0);
        locations.get(3).addExit("W", 1);
        //locations.get(3).addExit("Q", 0);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        //locations.get(4).addExit("Q", 0);
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        //locations.get(5).addExit("Q", 0);

        //Quitamos las Q para ponerlas en el constructor de la clase, ahorrando tiempo y código
    }

    private static void populateVocabulary() {
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
    }
}
