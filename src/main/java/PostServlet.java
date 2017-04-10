import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuki.wakisaka
 */
@WebServlet("/add-user")
public class PostServlet extends HttpServlet {

    private static final DBAccessor dbAccessor = DBAccessor.getInstance();

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='ja'>");
        out.println("<body>");
        out.println("<h2>");
        out.println("Add User");
        out.println("</h2>");
        out.println("<form method='post' action='/add-user'>");
        out.println("<p><label for='id'>ID: </label>");
        out.println("<input type='text' name='id'></p>");
        out.println("<p><label for='name'>NAME: </label>");
        out.println("<input type='text' name='name'></p>");
        out.println("<input type='submit' value='送信'>");
        out.println("</form>");
        out.println("<p><a href='/users'>See All Users</a></p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Exception exception = null;

        resp.setContentType("text/html");

        Map<String, String[]> body = req.getParameterMap();
        String id = body.get("id")[0];
        String name = body.get("name")[0];


        try {
            dbAccessor.setUser(Integer.parseInt(id), name);
        } catch (ClassNotFoundException e) {
            exception = e;
            e.printStackTrace();
        } catch (SQLException e) {
            exception = e;
            logger.warning(e.getMessage());
        }
        if (exception instanceof ClassNotFoundException) {
            resp.setStatus(500);
        } else {
            resp.setStatus(403);
            try (PrintWriter out = resp.getWriter();) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='ja'>");
                out.println("<body>");
                if (exception instanceof SQLException) {
                    out.println("<p>Update Failed!</p>");
                    out.println("<p>cause: " + exception.getMessage() + "</p>");
                }
                out.println("<h2>");
                out.println("Added User");
                out.println("</h2>");
                out.println("<p>" + id + "</p>");
                out.println("<p>" + name + "</p>");
                out.println("<p><a href='/add-user'>Add Another User</a></p>");
                out.println("<p><a href='/users'>See All Users</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}