package BD;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public final static String URL = "jdbc:mysql://localhost/my_bd";
    public final static String LOGIN = "root";
    public final static String PASSWORD = "root";
    final static Logger logger = Logger.getLogger(MyConnection.class);

    public Connection getConnection(){
        Connection connection =null;
        try {
            connection= DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            logger.error("Error in method 'getConnection' ");
        }

        return connection;
    }
}
