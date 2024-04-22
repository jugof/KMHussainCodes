package app.components;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/meet/*")
public class MeetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] intervals = {"Night", "Morning", "Afternoon", "Evening"};
        int i = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) / 6;
        String name = request.getPathInfo().substring(1);
        var bean = new GreeterBean(name, intervals[i]);
        request.setAttribute("greeter", bean);
        String ua = request.getHeader("USER-AGENT");
        String page = ua.contains("Mobile") ? "/mpmeet.jsp" : "/pcmeet.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
    
    
}
