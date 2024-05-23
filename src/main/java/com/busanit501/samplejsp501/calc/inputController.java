package com.busanit501.samplejsp501.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputController", urlPatterns = "/calc/input")
public class inputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        super.doGet(req, resp);
        System.out.println("작업순서1 : inputController 거쳐가기 doGet 받기");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("작업순서1 : inputController 거쳐가기 doPost 받기");
       String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.println(num1 + num2);

        resp.sendRedirect("/");
    }
}
