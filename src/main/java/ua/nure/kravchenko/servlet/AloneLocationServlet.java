package ua.nure.kravchenko.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.Location;
import ua.nure.kravchenko.entity.User;
import ua.nure.kravchenko.entity.help.LocationFindAdressReq;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/manager/location")
public class AloneLocationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Location loc = (Location) session.getAttribute("current_location");
        req.setAttribute("current_location", loc);
        System.out.println(loc);
        req.setAttribute("amount", loc.getUsersInTheLocation().size());
        req.setAttribute("workers", loc.getUsersInTheLocation());
        req.setAttribute("details", loc.getLocationDetails());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
        req.setAttribute("free", communication.freeUsers(headers));
        req.setAttribute("daily_statistic", communication.getDailyStatistics(headers, loc.getId()));


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Location loc = (Location) session.getAttribute("current_location");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
        if(req.getParameter("add")!=null){
                int chosenId = Integer.parseInt(req.getParameter("chosen_user"));
                System.out.println(chosenId);
                LocationFindAdressReq locationFindAdressReq  = new LocationFindAdressReq();
                locationFindAdressReq.setAddress(loc.getAdress());
                User result =  communication.setLocationToUser(headers, chosenId, locationFindAdressReq);
                if(result!=null){
                    req.setAttribute("info", "User was successfully added to the location");
                }else{
                    req.setAttribute("error", "User was not added to the location");
                }
        }
    }
}
