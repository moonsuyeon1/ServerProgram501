package com.busanit501.samplejsp501.lunch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lunch", urlPatterns = "/lunch")
public class LunchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forwarding to the lunch input form
        req.getRequestDispatcher("/WEB-INF/lunch/lunchInput.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handling form submission
        String menuName = req.getParameter("menuName"); // Corrected parameter name
        System.out.println("menuName 확인 :  " + menuName);

        if (menuName != null && menuName.equals("test")) {
            // If the menu name is "test", redirect to the main page
            resp.sendRedirect("/");
        } else {
            // If the menu name is not "test" or null, redirect back to the lunch input form
            resp.sendRedirect("/lunch");
        }
    }
}
