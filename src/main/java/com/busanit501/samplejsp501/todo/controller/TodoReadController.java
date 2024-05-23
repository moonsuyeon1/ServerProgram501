package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
@WebServlet(name="todoRead",urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.valueOf(req.getParameter("tno"));
            TodoDTO sample = todoService.getSelectOne(tno);
            log.info("TodoListController , 확인2, sample : " + sample);
            req.setAttribute("sample", sample);

            Cookie viewTodoCookie = findCookie(req.getCookies(),"viewTodos");
            String todoListResult = viewTodoCookie.getValue();
            boolean exist = false;

            if(todoListResult != null && todoListResult.indexOf(tno+"-")>=0) {
                exist = true;
            }

            if(!exist){
                todoListResult += tno+"-";
                viewTodoCookie.setValue(todoListResult);
                viewTodoCookie.setMaxAge(60*60*24);
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    private Cookie findCookie(Cookie[] cookies, String cookieName){
        Cookie targetCookie = null;

        if(cookies != null && cookies.length>0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    targetCookie = cookie;
                    break;
                }
            }
        }
        if(targetCookie == null){
            targetCookie = new Cookie(cookieName,"");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);
        }
        return targetCookie;
    }
}
