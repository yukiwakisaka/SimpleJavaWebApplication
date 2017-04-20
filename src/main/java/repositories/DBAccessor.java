package repositories;

import repositories.entity.Tweet;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static repositories.DBConfig.*;

/**
 * @author yuki.wakisaka
 */
public class DBAccessor {

    private static final DBAccessor instance = new DBAccessor();

    private static Logger logger = Logger.getLogger(DBAccessor.class.getSimpleName());

    public static DBAccessor getInstance() {
        return instance;
    }

    private static Connection getConnection() throws SQLException {
        logger.info(URL);
        logger.info(USER);
        logger.info(PASSWORD);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // TODO: ryohei 2017/04/20 リファクタリング時にselectUsersにメソッド名を変更 or UserRepositoryを作成し、selectメソッドを定義
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

    // TODO: ryohei 2017/04/20 リファクタリング時にinsertUsersにメソッド名を変更 or UserRepositoryを作成し、insertメソッドを定義
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

    public List<Tweet> selectAllTweet() {
        List<Tweet> tweets = new ArrayList<>();

        // TODO: 2017/04/20 JDBC実行部分をラップしたメソッドを作成
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery("SELECT * FROM tweets;")) {
            while (rset.next()) {
                long tweetId = rset.getLong(1);
                String userName = rset.getString(2);
                String tweetContext = rset.getString(3);
                tweets.add(new Tweet(tweetId, userName, tweetContext));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tweets;
    }
}