package fa.trainning.controller.ticketServlet;

import fa.trainning.entities.Ticket;
import fa.trainning.entities.Trip;
import fa.trainning.services.TicketService;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "ServletTicketUpdate", value = "/ServletTicketUpdate")
public class ServletTicketUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            int id = Integer.parseInt(request.getParameter("id"));

            String timeTemp  = request.getParameter("bookingTime");
            if (timeTemp.length() == 5){
                timeTemp= timeTemp+":00";
            }
            Time bookingTime = Time.valueOf(timeTemp);

            String customerName = request.getParameter("customerName");
            String licensePlate = request.getParameter("licensePlate");
            String trip = request.getParameter("trip");

            TripService tripService = new TripService();
            Trip  tripTemp = tripService.getTripByNameService(trip);


            Ticket newTicket = new Ticket(id, bookingTime, customerName, licensePlate, tripTemp.getTripId());
            boolean updated = ticketService.updateTicketService(newTicket);

            if (updated){
                request.setAttribute("successMessage", "Update Success!");
            } else {
                request.setAttribute("warningMessage", "Update Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletTicketViewAll");
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
