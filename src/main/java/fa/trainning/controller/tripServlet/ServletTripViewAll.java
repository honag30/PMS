package fa.trainning.controller.tripServlet;

import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletTripViewAll", value = "/ServletTripViewAll")
public class ServletTripViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
            List<Trip> listTrip = tripService.viewAllTripService();
            request.setAttribute("listTrip", listTrip);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/trip-views/trip-view-all.jsp");
            dispatcher.forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
