package app.components;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/welcome", "/hello"})
public class GreeterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String visitor = request.getParameter("name");
        if(visitor == null)
            visitor = "";
        response.setContentType("text/html");
        var out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>demo-web-app</title></head>");
        out.println("<body>");
        out.printf("<h1>Welcome Visitor %s</h1>%n", visitor);
        out.printf("<b>Current Time: </b>%s%n", new Date());
        out.println("</body>");
        out.println("</html>");
    }
 
    
}
