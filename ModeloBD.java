import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ModeloBD implements Modelo {

    private final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/mytube";
    // PESIMA IDEA PONER CREDENCIALES EN EL CODIGO FUENTE
    // NO LO HAGAN
    // REPITO NO LO HAGAN
    private final String DB_USER = "patito";
    private final String DB_PASS = "cuack";

    public List<String> leer (String filename) {
        // Explicitly load the MariaDB JDBC driver
        try {
            Class.forName("org.mariadb.jdbc.Driver"); 
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }

        // try-with-resources
        try (Connection conn = 
          DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASS)) {
            // Trabaja con la BD aquí
            Statement sentencia = conn.createStatement();
            ResultSet filas = sentencia.executeQuery("SELECT * FROM videos;");

            while(filas.next()) {
                int id = filas.getInt("id_video");
                String titulo = filas.getString("titulo");
                int duracion = filas.getInt("duracion_seg");

                System.out.println(id + " - " + titulo + " - " + duracion);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }

        return null;
    }

    public void escribir (String filename, List<String> contenido) {

    }

    @Override
    public String toString() {
        return "Hola soy un modelo de base de datos";
    }

    public static void main (String[] args) {
        System.out.println(new ModeloBD().toString());
    }
}