import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ModeloSQLite implements Modelo {

    private final String CONNECTION_STRING = "jdbc:sqlite:bd.sqlite";
    // PESIMA IDEA PONER CREDENCIALES EN EL CODIGO FUENTE
    // NO LO HAGAN
    // REPITO NO LO HAGAN
    private final String DB_USER = "patito";
    private final String DB_PASS = "cuack";

    public int insertar(String titulo, int duracion)  {
        // Primer paso: establecer la conexión 
        try { 
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }

        try (Connection conexion = DriverManager.getConnection(CONNECTION_STRING))
        {
            // Segundo paso: obtener un statement (para consultas estáticas)
            Statement sentencia = conexion.createStatement();
            PreparedStatement sentencia2 = conexion.prepareStatement(
                "INSERT INTO videos (id_canal, titulo, duracion_seg, url_video)"
                + " VALUES (1, ?, ?, 'kfhjgshfaxgch')"
            );

            // Paso 2.5 establecemos parámetros
            sentencia2.setString(1, titulo);
            sentencia2.setInt(2, duracion);

            // Tercer paso: ejecutar la consulta
            // String sql = "INSERT INTO videos (id_canal, titulo, duracion_seg, url_video) VALUES (1, '" + titulo + "', " + duracion + ", '0tR5T09BAcI');";
            // int filasAfectadas = sentencia.executeUpdate();
            int filasAfectadas = sentencia2.executeUpdate();

            return filasAfectadas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int eliminar (int id_video){
        try (Connection Conexion=DriverManager.getConnection(CONNECTION_STRING,DB_USER,DB_PASS)){
            PreparedStatement sentencia = Conexion.prepareStatement("delete from videos where id_video = ?;");
            sentencia.setInt(1,id_video);
            return sentencia.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

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

            // Esto se hace para las lecturas -> executeQuery
            ResultSet filas = sentencia.executeQuery("SELECT * FROM videos;");

            // Esto se hace para las sentencias que MODIFICAN los datos -> executeUpdate
            // int filasAfectadas = sentencia.executeUpdate("DELETE FROM videos;")

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