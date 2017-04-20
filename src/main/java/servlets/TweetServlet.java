package servlets;

import beans.TweetBean;
import repositories.DBAccessor;
import repositories.entity.Tweet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ryohei.yamamoto
 */
@WebServlet("/tweet")
public class TweetServlet extends HttpServlet {

    private static final DBAccessor dbAccessor = DBAccessor.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Tweet> result = dbAccessor.selectAllTweet();
        List<TweetBean> tweets = new ArrayList<>();
        for (Tweet tweet:  result){

        }

        req.setAttribute("tweets", tweets);

        RequestDispatcher rd = req.getRequestDispatcher("./jsp/users.jsp");
        rd.forward(req, resp);
    }
}

