package repositories;

/**
 * @author yuki.wakisaka
 */
class DBConfig {
//    static final String URL = System.getenv().getOrDefault("MYSQL_URL", System.getProperty("mysql.url", ""));
//    static final String USER = System.getenv().getOrDefault("MYSQL_USER", System.getProperty("mysql.user", ""));
//    static final String PASSWORD = System.getenv().getOrDefault("MYSQL_PW", System.getProperty("mysql.password", ""));
    static final String URL = System.getenv().getOrDefault("MYSQL_URL", System.getProperty("mysql.url", "jdbc:mysql://localhost:3306/17training"));
    static final String USER = System.getenv().getOrDefault("MYSQL_USER", System.getProperty("mysql.user", "root"));
    static final String PASSWORD = System.getenv().getOrDefault("MYSQL_PW", System.getProperty("mysql.password", ""));
}
