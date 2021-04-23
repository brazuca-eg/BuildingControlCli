package ua.nure.kravchenko.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.User;
import ua.nure.kravchenko.entity.help.RegistrationRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("butt") != null) {
            if(req.getParameter("login")==null || req.getParameter("password") == null
            || req.getParameter("password2") == null || req.getParameter("name") == null
            || req.getParameter("surname") == null){
                req.setAttribute("error", "All fields should be not null");
                doGet(req, resp);
            }else if(!req.getParameter("password").equals(req.getParameter("password2"))){
                req.setAttribute("error", "Passwords doesn't match each other");
                doGet(req, resp);
            } else{
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
                headers.setContentType(MediaType.APPLICATION_JSON);

                AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
                Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);

                RegistrationRequest registrationRequest = new RegistrationRequest();
                registrationRequest.setLogin(req.getParameter("login"));
                registrationRequest.setPassword(req.getParameter("password"));
                registrationRequest.setName(req.getParameter("name"));
                registrationRequest.setSurname(req.getParameter("surname"));
                User user = communication.register(registrationRequest);
                if(user!=null){
                    resp.sendRedirect(req.getContextPath() + "/login");
                }else{
                    req.setAttribute("error", "Something went wrong. Try again");
                    doGet(req, resp);
                }
            }
        }
    }
}
