import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    public static Map<Integer, String> getUsers() {
        Map<Integer, String> result = new HashMap<Integer, String>();

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/17training", "root", "");

            ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM users");
            while (rset.next()) {
                result.put(rset.getInt(1), rset.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static int setUser(int id, String name) {
        int result = 0;

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/17training", "root", "");

            result = conn.createStatement().executeUpdate(String.format("INSERT USERS VALUE(%d, '%s')", id, name));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}