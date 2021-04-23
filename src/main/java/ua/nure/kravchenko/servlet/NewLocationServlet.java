package ua.nure.kravchenko.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ua.nure.kravchenko.Communication;
import ua.nure.kravchenko.configuration.MyConfig;
import ua.nure.kravchenko.entity.Location;
import ua.nure.kravchenko.entity.help.LocationRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/manager/locations/create")
public class NewLocationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/location_create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("butt")!=null){
            if(req.getParameter("address")==null || req.getParameter("floor") == null
                    || req.getParameter("room") == null || req.getParameter("square") == null) {
                req.setAttribute("error", "All fields should be not empty");
                doGet(req, resp);
            }else{
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
                headers.setContentType(MediaType.APPLICATION_JSON);

                LocationRequest locationRequest = new LocationRequest();
                locationRequest.setAddress(req.getParameter("address"));
                locationRequest.setFloor(Integer.parseInt(req.getParameter("floor")));
                locationRequest.setRoom(Integer.parseInt(req.getParameter("room")));
                locationRequest.setSquare(Integer.parseInt(req.getParameter("square")));

                AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
                Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
                Location location = communication.createLocation(headers, locationRequest);
                if(location==null){
                    req.setAttribute("error", "Something went wrong");
                }else{
                    req.setAttribute("info", "Location was successfully added");
                }
                doGet(req, resp);
            }
        }
    }
}
