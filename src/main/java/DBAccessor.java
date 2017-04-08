import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    public static Map<String, String> getUsers() {
        Map<String, String> result = new HashMap<String, String>();

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/17training", "root", "");

            ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM users");
            while (rset.next()) {
                result.put(rset.getString(1), rset.getString(2));
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
}