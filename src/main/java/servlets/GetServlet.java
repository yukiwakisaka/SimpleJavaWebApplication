package servlets;

import repositories.DBAccessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuki.wakisaka
 */
@WebServlet("/users")
public class GetServlet extends HttpServlet {

    private static final DBAccessor dbAccessor = DBAccessor.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<Integer, String> users = new HashMap<Integer, String>();
        Exception exception = null;

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        try {
            users = dbAccessor.getUsers();
        } catch (ClassNotFoundException e) {
            exception = e;
            e.printStackTrace();
        } catch (SQLException e) {
            exception = e;
            e.printStackTrace();
        }

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ja\">");
        out.println("<body>");
        if (exception != null){
            out.println("<p>");
            out.println(exception);
            out.println("</p>");
        }
        out.println("<h2>");
        out.println("Users");
        out.println("</h2>");
        out.println("<p><a href=\"/add-user\">Add New User</a></p>");
        for (Map.Entry u : users.entrySet()) {
            out.println("id: ");
            out.println(u.getKey());
            out.println("<br>");
            out.println("name: ");
            out.println(u.getValue());
            out.println("<br><br>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
