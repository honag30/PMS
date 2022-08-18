package fa.trainning.controller.tripServlet;

import fa.trainning.entities.Trip;
import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "ServletTripUpdate", value = "/ServletTripUpdate")
public class ServletTripUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
            int id = Integer.parseInt(request.getParameter("id"));

            String carType = request.getParameter("carType");
            Date departureDate = Date.valueOf(request.getParameter("departureDate"));

            String timeTemp  = request.getParameter("departureTime");
            if (timeTemp.length() == 5){
                timeTemp= timeTemp+":00";
            }
            Time departureTime = Time.valueOf(timeTemp);

            String destination = request.getParameter("destination");
            String driver = request.getParameter("driver");
            int maximumOnlineTicketNumber = Integer.parseInt(request.getParameter("maximumOnlineTicketNumber"));

            Trip newTrip = new Trip(id, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
            boolean updated = tripService.updateTripService(newTrip);

            if (updated){
                request.setAttribute("successMessage", "Update Success!");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletTripViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
