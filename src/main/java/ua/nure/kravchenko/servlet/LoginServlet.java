package ua.nure.kravchenko.servlet;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.*;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.help.AuthRequest;
import ua.nure.kravchenko.entity.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("butt") != null) {
            if(req.getParameter("login")==null || (req.getParameter("password") == null)){
                req.setAttribute("error", "All fields should be not null");
                doGet(req, resp);
            }else{
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
                headers.setContentType(MediaType.APPLICATION_JSON);
                AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
                Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
                AuthRequest authRequest = new AuthRequest();
                authRequest.setLogin(req.getParameter("login"));
                authRequest.setPassword(req.getParameter("password"));
                User user = communication.auth(authRequest);
                if(user==null){
                    req.setAttribute("error", "No user with such params");
                    doGet(req, resp);
                }else{
                    HttpSession session = req.getSession();
                    session.setAttribute("current", user);
                    resp.sendRedirect(req.getContextPath() + "/main");
                }
            }
        }

    }
}
