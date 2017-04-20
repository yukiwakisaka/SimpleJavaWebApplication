package repositories.entity;

/**
 * @author ryohei
 */
public class Tweet {

    private Long tweetId;
    private String userName;
    private String tweetContext;

    public Tweet(Long tweetId, String userName, String tweetContext) {
        this.tweetId = tweetId;
        this.userName = userName;
        this.tweetContext = tweetContext;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
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
