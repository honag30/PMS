package fa.trainning.controller.bookingOfficeServlet;

import fa.trainning.entities.BookingOffice;
import fa.trainning.entities.Trip;
import fa.trainning.services.BookingOfficeService;
import fa.trainning.services.TripService;
import fa.trainning.utils.ErrorHandling;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletBookingOfficeCreate", value = "/ServletBookingOfficeCreate")
public class ServletBookingOfficeCreate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (BookingOfficeService bookingOfficeService = new BookingOfficeService();
             TripService tripService = new TripService()) {
            String officeName = request.getParameter("officeName");
            String destination = request.getParameter("destination");
            String officePhone = request.getParameter("officePhone");
            String officePlace = request.getParameter("officePlace");
            long officePrice = Long.parseLong(request.getParameter("officePrice"));
            Date startContractDeadline = Date.valueOf(request.getParameter("startContractDeadline"));
            Date endContractDeadline = Date.valueOf(request.getParameter("endContractDeadline"));

            Trip trip = tripService.getTripByNameService(destination);

            BookingOffice newBookingOffice = new BookingOffice(endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, trip.getTripId());
            boolean created = bookingOfficeService.createBookingOfficeService(newBookingOffice);

            if (created){
                request.setAttribute("successMessage", "Create Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletBookingOfficeViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
