package app.components;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String visitor = request.getParameter("user");
        if(visitor.length() == 0){
            response.sendRedirect("welcome");
        }else{
            var session = request.getSession(true);
            Integer count = (Integer) session.getAttribute(visitor);
            if(count == null)
                count = 1;
            session.setAttribute(visitor, count + 1);
            response.setContentType("text/html");
            var out = response.getWriter();
            out.printf("""
                    <html>
                        <head>
                            <title>demo-web-app</title>
                        </head>
                        <body>
                            <h1>Hello %s</h1>
                            <b>Number of Greetings: </b>%d
                        </body>
                    </html>
                    """, visitor, count);
            if(count > 4)
                session.invalidate();
        }
    }
    
    
}
