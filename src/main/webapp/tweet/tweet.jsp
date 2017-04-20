<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.*" %>
<%@ page import="java.util.List" %>

<% List<TweetBean> tweets = (List<TweetBean>) request.getAttribute("tweets"); %>

<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Tweet</h2>
<p><a href="/add-tweet">Add New Tweet</a></p>

<div id="timeline" class="timeline">
    <ol class="stream-items">
        <% for (TweetBean tweet : tweets) { %>
        <li class='stream-item'>
            <div class="tweet">
                <div class="content">
                    <div class="stream-item-header">
                        <a class="account-group" href="#">
                            <span class="nickname"><strong><% tweet.getUserName(); %></strong></span>
                        </a>
                    </div>
                    <div class="tweet-context-container">
                        <p class="tweet-context">
                            <% tweet.getTweetContext(); %>
                        </p>
                    </div>
                </div>
            </div>
        </li>
        <% } %>
    </ol>
</div>
</body>
</html>
