package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection() {
        String dbName = "bilet_rezervasyon";
        String kullaniciAdi = "root";
        String parola = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, kullaniciAdi, parola);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
