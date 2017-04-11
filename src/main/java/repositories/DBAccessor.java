package repositories;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    private static final DBAccessor instance = new DBAccessor();

    //static final String URL = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/17training");
    private static final String URL = System.getProperty("mysql.url", "jdbc:mysql://localhost:3306/17training");
    private static final String USER = System.getProperty("mysql.user", "root");
    private static final String PASSWORD = System.getProperty("mysql.password", "");

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    public static DBAccessor getInstance() {
        return instance;
    }

    public Map<Integer, String> getUsers() throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver"); // javaのversionによって要らない
        Map<Integer, String> result = new HashMap<Integer, String>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery("SELECT * FROM users;")) {
            while (rset.next()) {
                result.put(rset.getInt(1), rset.getString(2));
            }
        }
        return result;
    }

    public int setUser(int id, String name) throws ClassNotFoundException, SQLException {

        int result;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT USERS VALUE(?, ?);")) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            logger.info(pstmt.toString());
            result = pstmt.executeUpdate();
        }
        return result;
    }
}