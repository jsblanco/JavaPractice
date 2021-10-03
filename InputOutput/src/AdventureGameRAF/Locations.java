package AdventureGameRAF;

import java.io.*;
import java.util.*;

// Esta clase se comporta como un Map normal, pero podemos customizarla para cargar información de archivos, etc.
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    static {
        try {
            readRandomAccessObjects();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        indexAndSerializeLocations();
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitParts = exits.split(",");

        Location location = new Location(locationId, description, null);
        if (locationId != 0)
            for (int i = 0; i < exitParts.length; i++)
                location.addExit(exitParts[i], Integer.parseInt(exitParts[++i]));

        return location;
    }

    private static void readRandomAccessObjects() throws IOException {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        } catch (IOException e) {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }
    }


    private static void indexAndSerializeLocations() throws IOException {
        // El 1er parámetro indica que queremos abrir el archivo para leer y escribir, y que escrituras ocurran sincrónicamente.
        // Con este parámetro la clase RAF se ocupará de sincronizar los datos escritos, sino deberíamos hacerlo nosotros.
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            // 1. Los primeros 4 bytes tendrán el número de localizaciones /bytes 0 a 3)
            // 2. Los siguientes 4 bytes tendrán el offset inicial de la sección de localizaciones (bytes 4 a 7)
            // 3. La siguiente sección contendrá el índice al completo (bytes 8 a 1699);
            // 4. Finalmente vienen las localizaciones en sí, empezando en el byte 1700.
            rao.writeInt(locations.size());

            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.write(locationStart);

            // Primero anotaremos todas las localizaciones, y después crearemos el índice de golpe.
            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            for (Location location : locations.values()) {
                rao.writeInt(location.getLocationId());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());
                IndexRecord record = new IndexRecord(startPointer, (int) rao.getFilePointer() - startPointer);
                index.put(location.getLocationId(), record);
                startPointer = (int) rao.getFilePointer();
            }
            rao.seek(indexStart);
            for (Integer locationId : index.keySet()) {
                rao.writeInt(locationId);
                rao.writeInt(index.get(locationId).getStartByte());
                rao.writeInt(index.get(locationId).getLength());
            }
        }
    }

    public void close() throws IOException {
        ra.close();
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
