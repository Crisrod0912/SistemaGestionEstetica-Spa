package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "sges";
    private final String USR = "root";
    private final String PWD = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

    public Connection conectar() throws SQLException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL + DB, USR, PWD);
            return conn;
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Error al cargar el driver de la base de datos: " + ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new SQLException("Error al establecer la conexión a la base de datos: " + ex.getMessage(), ex);
        }
    }

    public void desconectar() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión finalizada. ");
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexión a la base de datos: " + ex.getMessage(), ex);
            }
        }
    }
}
