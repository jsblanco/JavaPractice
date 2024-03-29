package AdventureGameRAF;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Locations locations = new Locations();
    private static final Map<String, String> vocabulary = new HashMap<>();
    private static Location currentLocation;

    public static void main(String[] args) throws IOException {
        startGame();
    }

    private static void startGame() throws IOException {
        currentLocation = locations.getLocation(64);
        populateVocabulary();
        System.out.println("¡Bienvenido a Kamurocho!\nComienza a explorar sus calles.");
        startGameLoop();
    }

    private static void startGameLoop() throws IOException {
        while (true) {
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationId() == 0) break;

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.println(exits.keySet());
            stateExits(exits);

            String direction = getDirection();
            changeLocation(exits, direction);
        }
    }

    private static void stateExits(Map<String, Integer> exits) {
        System.out.println("De aquí puedes ir a: ");
        for (String exit : exits.keySet())
            System.out.print(exit + ", ");
        System.out.println();
    }

    private static void changeLocation(Map<String, Integer> exits, String direction) throws IOException {
        if (exits.containsKey(direction))
            currentLocation = locations.getLocation(exits.get(direction));
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
