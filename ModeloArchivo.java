import java.util.List;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ModeloArchivo implements Modelo {
    
    public List<String> leer(String nombreArchivo) {
        try {
            Path ruta = Paths.get(nombreArchivo);
            List<String> contenido = 
              Files.readAllLines(ruta);
            
            return contenido;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void escribir(
      String nombreArchivo, 
      List<String> contenido
    ) {
        try {
            Path ruta = Paths.get(nombreArchivo);
            Files.write(ruta, contenido);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}