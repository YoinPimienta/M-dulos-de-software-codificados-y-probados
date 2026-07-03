package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/sicaps";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "2910";

    public Connection conectar() {

        Connection conexion = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a MySQL");

        } catch (Exception e) {

            System.out.println("ERROR COMPLETO:");
            e.printStackTrace();

        }

        return conexion;
    }
}
