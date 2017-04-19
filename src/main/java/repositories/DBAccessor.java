package repositories;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static repositories.DBConfig.*;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    private static final DBAccessor instance = new DBAccessor();

    private static Logger logger = Logger.getLogger("DBAccessor");
//    private static Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    public static DBAccessor getInstance() {
        return instance;
    }

    private static Connection getConnection() throws SQLException {
        logger.info(URL);
        logger.info(USER);
        logger.info(PASSWORD);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Map<Integer, String> getUsers() throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver"); // javaのversionによって要らない
        Map<Integer, String> result = new HashMap<Integer, String>();

        try (Connection conn = getConnection();
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

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT USERS VALUE(?, ?);")) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            logger.info(pstmt.toString());
            result = pstmt.executeUpdate();
        }
        return result;
    }
}