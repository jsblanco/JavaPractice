package AdventureGameRework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Esta clase se comporta como un Map normal, pero podemos customizarla para cargar información de archivos, etc.
public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new HashMap<>();

    static {
        // populateLocations();
        readDataFromFileBeforeJava7();
    }

    public static void main(String[] args) throws IOException {
        populateLocations();
        writeDataToFileAfterJava7();
    }

    private static void readDataFromFileBeforeJava7() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }

        // BufferedReader crea un array de caracteres del archivo leido para el scanner.
        // Permite un mayor rendimiento, al evitar los instantes perdidos buscando en el disco duro.
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));

            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dirString = scanner.nextLine();
//                int destination = Integer.parseInt(dirString);

                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }

    }

    private static void writeDataToFileAfterJava7() throws IOException {
//      try with resources cierra los streams automáticamente,
//      Si hay errores en el Try subirá ese error e ignorará los errores causados al cerrar el stream
        try (
                FileWriter locFile = new FileWriter("locations.txt");
                FileWriter dirFile = new FileWriter("directions.txt")
        ) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet())
                    dirFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + '\n');
            }
        }
    }

    private static void writeToFileBeforeJava7() throws IOException {
        FileWriter locFile = null;
////      Gracias a incluir el error que esperamos al definir el método, podemos prescindir de los Catch
////      (excepto si queremos hacer algo específico más que meramente mostrar el error)
        try {
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values())
                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
        } finally {
            if (locFile != null) locFile.close();
        }

//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values())
//                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
//        } catch (IOException e) {
//            System.out.println("Exception catched upon writing file");
//            e.printStackTrace();
//        } finally {
//            System.out.println("Finally...");
//            try {
//                if (locFile != null) locFile.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static void populateLocations() {
        locations.put(0, new Location(0, "Te vas de Kamurocho por el arco de Tenkaichi St.", null));

        Map<String, Integer> exits = new HashMap<>();
        exits.put("N", 5);
        exits.put("S", 4);
        exits.put("E", 3);
        exits.put("W", 2);
        locations.put(1, new Location(1, "Estás en la azotea de la Millenium Tower", exits));

        exits = new HashMap<>();
        exits.put("N", 5);
        locations.put(2, new Location(2, "Estás en el Sega de Theatre Square jugando a MesuKing", exits));

        exits = new HashMap<>();
        exits.put("W", 1);
        locations.put(3, new Location(3, "Estás en Earth Angel tomándote un copazo", exits));

        exits = new HashMap<>();
        exits.put("N", 1);
        exits.put("W", 2);
        locations.put(4, new Location(4, "Estás en Don Quijote cantando la musiquilla", exits));

        exits = new HashMap<>();
        exits.put("Q", 1);
        exits.put("W", 2);
        locations.put(5, new Location(5, "Estás en Kamurocho Hills en la planta baja", exits));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
