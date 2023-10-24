package by.teachmeskills.lesson22;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class LocalTimeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String local = request.getServletPath();
        if (local != null) {
            ZonedDateTime date = ZonedDateTime.now(ZoneId.of("/beijing".equalsIgnoreCase(local) ? "Asia/Shanghai"
                    : "/washington".equalsIgnoreCase(local) ? "America/Virgin" : "Europe/Minsk"));

            response.getWriter().println(DateTimeFormatter.ofPattern("HH:mm").format(date));
        } else {
            response.getWriter().println("Введите уже что-нибудь нормальное");
        }
    }
}
