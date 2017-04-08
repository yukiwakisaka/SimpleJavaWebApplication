import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuki.wakisaka
 */
public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> users = DBAccessor.getUsers();

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>");
        out.println("Users");
        out.println("</h2>");
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
