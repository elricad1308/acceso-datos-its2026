import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class ModeloBinario implements Modelo {

    private int charSection = 4 * 2; // 4 chars de 2 bytes c/u
    private int intSection = 2 * 4; // 2 ints de 4 bytes c/u
    private int doubleSection = 1 * 8; // 1 double de 8 bytes c/u
    private int rowSize = charSection + intSection + doubleSection; // 24 bytes 

    public List<String> leer (String nombreArchivo) {
        return null;
    }

    public void escribir (String nombreArchivo, List<String> contenido) {
        ByteBuffer buffer = ByteBuffer.allocate(rowSize);

        // hola,1,2,3.14156926
        for (String linea: contenido)
        {
            String[] datos = linea.split(",");
            //for (int i = 0; i < 4; i++)
            //{
            // Guardamos 4 chars
            buffer.putChar(datos[0].charAt(0));
            buffer.putChar(datos[0].charAt(1));
            buffer.putChar(datos[0].charAt(2));
            buffer.putChar(datos[0].charAt(3));
            //}

            // Guardamos 2 ints
            buffer.putInt(Integer.parseInt(datos[1]));
            buffer.putInt(Integer.parseInt(datos[2]));

            // Guardamos 1 double
            buffer.putDouble(Double.parseDouble(datos[3]));

            try {
                // Obtenemos el handler
                Path ruta = Paths.get("save.bin");

                // Escribimos el buffer en el disco
                Files.write(ruta, buffer.array(), StandardOpenOption.APPEND);

                buffer.clear();
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

}