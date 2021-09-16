package AdventureGameRework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Locations locations = new Locations();
    private static final Map<String, String> vocabulary = new HashMap<String, String>();
    private static int loc;

    public static void main(String[] args) {
        startGame();

        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            stateExits(exits);

            String direction = getDirection();
            changeLocation(exits, direction);
        }
    }

    private static void startGame() {
        loc = 1;
        populateVocabulary();

        System.out.println("¡Bienvenido a Kamurocho!\nComienza a explorar sus calles.");
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
        String direction = scanner.nextLine().toUpperCase();
        if (direction.length() > 1) {
            String[] inputWords = direction.split(" ");
            for (String word : inputWords)
                if (vocabulary.containsKey(word)) {
                    direction = vocabulary.get(word);
                    break;
            }
        }
        return direction;
    }

    private static void populateVocabulary() {
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
    }
}
