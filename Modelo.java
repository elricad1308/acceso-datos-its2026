import java.util.List;

public interface Modelo {
    
    public List<String> leer(String nombreArchivo);
    
    public void escribir(
      String nombreArchivo, 
      List<String> contenido
    );
    
}