package repositories;

/**
 * @author yuki.wakisaka
 */
class DBConfig {
    private DBConfig(){};

    private static final DBConf CONF = DBConf.get(System.getProperty("dbconf"));
    private static final String RES = "config";

    private static String url;
    private static String user;
    private static String password;

    static {
        switch (CONF) {
            case ENV:
                url = System.getenv().get("MYSQL_URL");
                user = System.getenv().get("MYSQL_USER");
                password = System.getenv().get("MYSQL_PASSWORD");
                break;
            case SYSTEM:
                url = System.getProperty("mysql.url", "");
                user = System.getProperty("mysql.uer", "");
                password = System.getProperty("mysql.password", "");
                break;
            case RESOURCE:
                url = java.util.ResourceBundle.getBundle(RES).getString("mysql.url");
                user = java.util.ResourceBundle.getBundle(RES).getString("mysql.user");
                password = java.util.ResourceBundle.getBundle(RES).getString("mysql.password");
                break;
            default:
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}

enum DBConf {
    ENV("ENV"),
    SYSTEM("SYS"),
    RESOURCE("RES"),
    DEFAULT("DEF");

    String dbconf;

    DBConf(String dbconf) {
        this.dbconf = dbconf;
    }

    public static DBConf get(String dbconf) {
        if (dbconf == null) return RESOURCE;

        DBConf cf = DEFAULT;
        for (DBConf c : DBConf.values()) {
            if (dbconf.equals(c.name())) {
                cf = c;
                break;
            }
        }
        return cf;
    }
}