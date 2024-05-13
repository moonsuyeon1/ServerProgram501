package com.busanit501.samplejsp501;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "myServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    //doGet 매서드 이름
    //HttpServletRequest request, HttpServletResponse response 매개변수, 받는 변수, 매서드 정의하는 곳.
    //throws : 예외 발생하면 IOException
    //throw 강제로 예외를 발생
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "내가 만든 myServlet" + "</h1>");
        out.println("</body></html>");
    }
}
