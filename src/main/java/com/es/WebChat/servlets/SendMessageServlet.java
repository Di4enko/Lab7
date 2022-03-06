package com.es.WebChat.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendMessageServlet extends ChatServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
        pw.println("<form action=\"/WebChat/send_message.do\" method=\"post\">\n" +
                "    Message text:\n" +
                "    <input type=\"text\" name=\"message\" style=\"width: 50%\">\n" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "    </form>" +
                "    <a href=\"/WebChat/logout.do\" target=\"_top\"><button>Exit from chat</button></a>");
        pw.println("</body></html>");
    }
}
