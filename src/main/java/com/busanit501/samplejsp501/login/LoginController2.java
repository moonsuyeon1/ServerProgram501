package com.busanit501.samplejsp501.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController2", urlPatterns = "/login-result")
public class LoginController2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the user ID from the request parameter
        String id = req.getParameter("mid");

        if (id != null && id.equals("맥도날드")) { // Check if the ID is "맥도날드"
            // If the ID is correct, redirect to the main page
            resp.sendRedirect("/");
        } else {
            // If the ID is incorrect or null, redirect back to the login form
            resp.sendRedirect("/login");
        }
    }
}
