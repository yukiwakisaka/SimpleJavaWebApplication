package beans;

/**
 * @author ryohei.yamamato
 */
public class TweetBean {

    private int id;
    private String userName;
    private String tweetContext;

    public TweetBean(int id, String userName, String tweetContext) {
        this.id = id;
        this.userName = userName;
        this.tweetContext = tweetContext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTweetContext() {
        return tweetContext;
    }

    public void setTweetContext(String tweetContext) {
        this.tweetContext = tweetContext;
    }
}
