package AdventureGameNIO;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new LinkedHashMap<>();
    private static final boolean debug = !false;

    static {
        try {
            // readLocationsNIO();
            readSerialisedLocationsNIO();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //  writeLocationsNIO();
        serializeLocationsNIO();
    }

    private static void readSerialisedLocationsNIO() throws IOException, ClassNotFoundException {
        Path locPath = FileSystems.getDefault().getPath("locations_nio.dat");
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    if (debug)
                        System.out.println("Reading location " + location.getLocationId());
                    locations.put(location.getLocationId(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }
    }

    private static void serializeLocationsNIO() throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations_nio.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(Files.newOutputStream(locPath))) {
            for (Location location : locations.values())
                locFile.writeObject(location);
        }
    }

    private static void readLocationsNIO() throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations_nio.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_nio.txt");

        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                if (debug)
                    System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new Location(loc, description, null));
            }
        }

        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                if (debug)
                    System.out.println("New exit: " + loc + " " + direction + " to " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }
    }

    private static void writeLocationsNIO() throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations_nio.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_nio.txt");
        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet())
                    if (!direction.equalsIgnoreCase("Q"))
                        dirFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + "\n");
            }
        }
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
        for (Location location : m.values())
            locations.put(location.getLocationId(), location);
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
