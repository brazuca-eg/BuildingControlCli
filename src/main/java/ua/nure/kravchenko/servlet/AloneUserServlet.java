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

@WebServlet("/manager/user")
public class AloneUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User chosenUser = (User) session.getAttribute("us");
        req.setAttribute("us", chosenUser);
        req.setAttribute("loc", chosenUser.getLocation());

        if(req.getParameter("open_loc") != null) {
            session.setAttribute("current_location", chosenUser.getLocation());
            resp.sendRedirect(req.getContextPath() + "/manager/location");
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User chosenUser = (User) session.getAttribute("us");
        HttpHeaders headers = new HttpHeaders();
        User user = (User) session.getAttribute("current");
        headers.set("Authorization", "Bearer " + user.getToken());
        HttpEntity<String> request = new HttpEntity<>(headers);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
        if (req.getParameter("accept") != null) {
            communication.acceptRequest(chosenUser.getId(), request);
            req.setAttribute("info", "Request was successfully accepted");
            User updateUser = communication.user(chosenUser.getId(), request);
            session.setAttribute("us", updateUser);
        }
        if (req.getParameter("decline") != null) {
            communication.declineRequest(chosenUser.getId(), request);
            req.setAttribute("info", "Request was successfully declined");
            User updateUser = communication.user(chosenUser.getId(), request);
            session.setAttribute("us", updateUser);
        }
        doGet(req, resp);
    }
}
