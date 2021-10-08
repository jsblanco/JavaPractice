import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    static byte[] outputBytes;
    static ByteBuffer buffer;
    static ByteBuffer intBuffer;

    public static void main(String[] args) {
        try {
            // writeManually();
            writeInBinary();

            // readFileUsingJavaIO(outputBytes);
            readFileUsingJavaNIO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInBinary() throws IOException {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            outputBytes = "Hello World!".getBytes();
            buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(254);
            // Es necesario resetear la posición del buffer al inicio, porque ahora está al final, y no se escribirá
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            // Sin flip() tendremos un error de Buffer Overflow. Esto es porque hemos asignado a este buffer un valor de 4
            // posiciones (en el Allocate) y, tras haber escrito, su posición ya estaba en el 4. Esta posición queda
            // fuera del espacio asignado al buffer, por lo que, al intentar escribir ahí, salta el error de buffer overflow.
            // Haciendo Flip devolvemos la posición al inicio (0) y podemos volver a añadir información al buffer,
            // reescribiendo su contenido.
            intBuffer.flip();
            intBuffer.putInt(-5985);
            // Volvemos a hacer flip para devolver la posición al inicio, con tal de que write() escriba el buffer
            // entero. Sino escribirá en el archivo lo que hay al final del buffer; es decir, nada.
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);
        }
    }

    private static void readFileUsingJavaNIO() throws IOException {
        RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
        FileChannel channel = ra.getChannel();

        outputBytes[0] = 'a';
        outputBytes[1] = 'b';
        long numBytesRead = channel.read(buffer);

        // Java ahora abre un canal con el archivo, y transmite lo leido al buffer creado antes sobre outputBytes.
        // Read debería sustituir las posiciones erróneas de outputBytes por los valores correctos que están en el archivo,
        // pero no lo hace. Esto es porque el buffer está en una posición tardía, al no haberlo devuelto al inicio tras
        // escribir por última vez. Por eso, la lectura del buffer "ignora" lo que se encuentra antes de su posición.
        System.out.println("Output bytes before using flip: " + new String(outputBytes));
        buffer.flip();
        numBytesRead = channel.read(buffer);

        // Al devolver la posición del buffer al inicio usando flip(), la lectura del buffer nos devuelve el contenido
        // total del archivo (lo que se encuentra después del pointer, que, al estar éste al inicio, viene a ser el
        // contenido entero del archivo), sustituyendo las posiciones erróneas que pusimos en [0] y [1].
        System.out.println("Output bytes after using flip: " + new String(outputBytes));
        if (buffer.hasArray()) System.out.println("Byte buffer: " + new String(buffer.array()));

        // Si leemos en base a la posición del buffer, estamos haciendo una lectura relativa
        readDataRelatively(channel);

        channel.position(12);
        // Si leemos en base a la posición indicada en un parámetro estamos haciendo una lectura absoluta
        readDataAbsolutely(channel);


        channel.close();
        ra.close();
    }

    private static void readDataAbsolutely(FileChannel channel) throws IOException {
        long numBytesRead;
        intBuffer.flip();
        numBytesRead = channel.read(intBuffer);
        System.out.println("First int (absolute read): " + intBuffer.getInt(0));
        intBuffer.flip();
        numBytesRead = channel.read(intBuffer);
        System.out.println("Second int (absolute read): " + intBuffer.getInt(0));
    }

    private static void readDataRelatively(FileChannel channel) throws IOException {
        long numBytesRead;
        intBuffer.flip();
        numBytesRead = channel.read(intBuffer);
        intBuffer.flip();
        System.out.println("First int (relative read): " + intBuffer.getInt());
        intBuffer.flip();
        numBytesRead = channel.read(intBuffer);
        intBuffer.flip();
        System.out.println("Second int (relative read): " + intBuffer.getInt());
    }

    private static void readFileUsingJavaIO(byte[] outputBytes) throws IOException {
        RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
        byte[] b = new byte[outputBytes.length];
        ra.read(b);
        // Devuelve "Hello world!" porque solamente lee los bytes que caben en el array, al cual hemos dato un
        // tamaño equivalente al de los bits de esa string. Por tanto, los bits adicionales de lo que hemos escrito
        // después no caben en el array, y no los veremos en el sout.
        System.out.println(new String(b));

        long int1 = ra.readInt();
        long int2 = ra.readInt();
        System.out.println(int1 + " " + int2);
    }


    public static void writeManually() throws IOException {
        FileInputStream file = new FileInputStream("data.txt");
        FileChannel channel = file.getChannel();
        Path dataPath = FileSystems.getDefault().getPath("data.txt");
        Files.write(dataPath, "\nLine 3".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        List<String> lines = Files.readAllLines(dataPath);
        for (String line : lines)
            System.out.println(line);
    }
}
