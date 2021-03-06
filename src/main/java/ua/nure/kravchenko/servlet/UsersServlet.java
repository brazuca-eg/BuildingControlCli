package ua.nure.kravchenko.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        HttpHeaders headers = new HttpHeaders();
        User user = (User) session.getAttribute("current");
        headers.set("Authorization", "Bearer " + user.getToken());
        HttpEntity<String> request = new HttpEntity<>(headers);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);

        List<User> users = communication.users(request);

        req.setAttribute("users", users );
        if (req.getParameter("butt") != null) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            User us = communication.user(userId, request);
            session.setAttribute("us", us);
            resp.sendRedirect(req.getContextPath() + "/manager/user");
            return;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/all_users.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
