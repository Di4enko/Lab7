package com.es.WebChat.servlets;

import com.es.WebChat.entity.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends ChatServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        if (name!=null) {
            ChatUser aUser = activeUsers.get(name);
            if (aUser.getSessionId().equals((String)
                    request.getSession().getId())) {
                synchronized (activeUsers) {
                    activeUsers.remove(name);
                }
                request.getSession().setAttribute("name", null);
                response.addCookie(new Cookie("sessionId", null));
                response.sendRedirect(response.encodeRedirectURL("/WebChat/login.do"));
            } else {
                request.getRequestDispatcher("/WEB-INF/pages/view.html").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/view.html").forward(request, response);
        }
    }
}
