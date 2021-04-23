package ua.nure.kravchenko.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.Location;
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

@WebServlet("/manager/locations")
public class LocationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HttpHeaders headers = new HttpHeaders();
        User user = (User) session.getAttribute("current");
        headers.set("Authorization", "Bearer " + user.getToken());
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
        List<Location> locations = communication.getAllLocations(headers);
        req.setAttribute("locations", locations);

        if(req.getParameter("butt")!=null){
            int locId = Integer.parseInt(req.getParameter("locId"));
            Location location = communication.getLocation(headers, locId);
            session.setAttribute("current_location", location);
            resp.sendRedirect(req.getContextPath() + "/manager/location");
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/locations.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
