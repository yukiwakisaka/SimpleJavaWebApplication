import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    private static final DBAccessor instance = new DBAccessor();

    //static final String URL = System.getenv().getOrDefault("URL", "jdbc:mysql://localhost:3306/17training");
    private static final String URL = System.getProperty("mysql.url", "jdbc:mysql://localhost:3306/17training"); // TODO javaコマンドの引数を取得可能 -Dmysql.url=xxxxxxx
    private static final String USER = System.getProperty("mysql.user", "root");
    private static final String PASSWORD = System.getProperty("mysql.password", "");


    public static DBAccessor getInstance() {
        return instance;
    }

    public Map<Integer, String> getUsers() throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver"); // javaのversionによって要らない
        Map<Integer, String> result = new HashMap<Integer, String>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rset = stmt.executeQuery("SELECT * FROM users;");
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
            System.out.println(pstmt.toString());
            result = pstmt.executeUpdate();
        }
        System.out.println(result);
        return result;
    }
}