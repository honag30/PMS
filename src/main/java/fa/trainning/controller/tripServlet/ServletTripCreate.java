package fa.trainning.controller.tripServlet;

import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "ServletTripCreate", value = "/ServletTripCreate")
public class ServletTripCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
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

            Trip newTrip = new Trip(carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);

            boolean created = tripService.createTripService(newTrip);

            if (created){
                request.setAttribute("successMessage", "Create Success!");
            } else {
                request.setAttribute("warningMessage", "Create Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletTripViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
