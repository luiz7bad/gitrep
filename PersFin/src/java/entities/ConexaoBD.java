package entities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Darth Vader
 */
public class ConexaoBD {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static String user = "root";
    private static String password = "firejl07";
    

    public static Connection openDBConnection() {

        Connection conneccion = null;
        try {
            Class.forName(driver).newInstance();
            conneccion = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            System.out.println("Não foi possível criar uma conexão com o driver:" + driver + " url:" + url + " user:" + user + " pass:" + password + "Error: " + ex);

        }
        return conneccion;
    }
}
