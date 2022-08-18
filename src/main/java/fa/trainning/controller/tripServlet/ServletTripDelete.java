package fa.trainning.controller.tripServlet;

import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTripDelete", value = "/ServletTripDelete")
public class ServletTripDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TripService tripService = new TripService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean deleted = tripService.deleteTripService(id);

            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletTripViewAll");
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
