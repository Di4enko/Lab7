package com.es.WebChat.servlets;

import com.es.WebChat.Dao.Impl.DirectChatDaoImpl;
import com.es.WebChat.Dao.interfaces.DirectChatDao;
import com.es.WebChat.entity.ChatMessage;
import com.es.WebChat.entity.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServlet extends HttpServlet {
    protected DirectChatDao chatDao;
    private static final long serialVersionUID = 1L;
    protected ConcurrentHashMap<String, ChatUser> activeUsers;
    protected ArrayList<ChatMessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        super.init();
        chatDao = DirectChatDaoImpl.getInstance();
        activeUsers = (ConcurrentHashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages");
        if (activeUsers==null) {
            activeUsers = new ConcurrentHashMap<String, ChatUser>();
            getServletContext().setAttribute("activeUsers", activeUsers);
        }
        if (messages==null) {
            messages = new ArrayList<ChatMessage>(100);
            getServletContext().setAttribute("messages", messages);
        }
    }
}
