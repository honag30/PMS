package fa.trainning.controller.tripServlet;

import fa.trainning.entities.Trip;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTripGetById", value = "/ServletTripGetById")
public class ServletTripGetById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            Trip trip = tripService.getTripByIdService(id);
            request.setAttribute("trip", trip);

            RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/assets/views/trip-views/trip-form.jsp");
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
