package fa.trainning.controller.tripServlet;

import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTripEdit", value = "/ServletTripEdit")
public class ServletTripEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            Trip existingTrip = tripService.getTripByIdService(id);
            request.setAttribute("existingTrip", existingTrip);

            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/trip-views/trip-form.jsp");
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
