import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    static final String MYSQL_URL = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/17training?user=root&password=");

    public static Map<Integer, String> getUsers() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(MYSQL_URL);

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM users");
        Map<Integer, String> result = new HashMap<Integer, String>();
        while (rset.next()) {
            result.put(rset.getInt(1), rset.getString(2));
        }
        conn.close();

        return result;
    }

    public static int setUser(int id, String name) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(MYSQL_URL);

        int result = conn.createStatement().executeUpdate(String.format("INSERT USERS VALUE(%d, '%s')", id, name));
        conn.close();

        return result;
    }
}