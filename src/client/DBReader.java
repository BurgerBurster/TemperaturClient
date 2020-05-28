package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBReader {
    private String url;

    public void getAllData() {
        try (Connection con = DriverManager.getConnection(url)) {
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
