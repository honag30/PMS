package fa.trainning.controller.ticketServlet;

import fa.trainning.entities.Car;
import fa.trainning.entities.Ticket;
import fa.trainning.entities.Trip;
import fa.trainning.services.CarService;
import fa.trainning.services.TicketService;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;

@WebServlet(name = "ServletTicketCreate", value = "/ServletTicketCreate")
public class ServletTicketCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            CarService carService = new CarService();
            TripService tripService = new TripService();

            String timeTemp  = request.getParameter("bookingTime");
            if (timeTemp.length() == 5){
                timeTemp= timeTemp+":00";
            }
            Time bookingTime = Time.valueOf(timeTemp);

            String customerName = request.getParameter("customerName");

            String licensePlate = request.getParameter("licensePlate");
            Car car = carService.getCarByLicensePlateService(licensePlate);

            String destination = request.getParameter("trip");
            Trip trip = tripService.getTripByNameService(destination);

            Ticket newTicket = new Ticket(bookingTime, customerName, car.getLicensePlate(),  trip.getTripId());
            boolean created = ticketService.createTicketService(newTicket);

            if (created){
                request.setAttribute("successMessage", "Create Success!");
            } else {
                request.setAttribute("warningMessage", "Create Fail!");
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
