import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    public static Map<Integer, String> getUsers() throws ClassNotFoundException, SQLException {
        Map<Integer, String> result = new HashMap<Integer, String>();

        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/17training", "root", "");

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM users");
        while (rset.next()) {
            result.put(rset.getInt(1), rset.getString(2));
        }
        conn.close();
        return result;
    }

    public static int setUser(int id, String name) throws ClassNotFoundException, SQLException {
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/17training", "root", "");

        result = conn.createStatement().executeUpdate(String.format("INSERT USERS VALUE(%d, '%s')", id, name));
        conn.close();
        return result;
    }
}