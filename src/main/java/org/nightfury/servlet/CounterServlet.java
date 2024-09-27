package org.nightfury.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }

        counter++;

        session.setAttribute("counter", counter);

        request.setAttribute("counter", counter);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/counter.jsp");
        dispatcher.forward(request, response);
    }
}
