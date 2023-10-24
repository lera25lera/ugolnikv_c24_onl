package by.teachmeskills.lesson22;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/adult")
public class AdultServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (ChecksForServlet.checkAge(Integer.parseInt(request.getParameter("age")))) {
                response.getWriter().println("Not adult");
            } else {
                response.getWriter().println("Adult");
            }
        } catch (NumberFormatException ex) {
            response.getWriter().println("Incorrect age parameter");
        }
    }
}
