package fa.trainning.controller.bookingOfficeServlet;

import fa.trainning.entities.BookingOffice;
import fa.trainning.entities.Employee;
import fa.trainning.entities.Trip;
import fa.trainning.services.BookingOfficeService;
import fa.trainning.services.EmployeeService;
import fa.trainning.services.TripService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletBookingOfficeUpdate", value = "/ServletBookingOfficeUpdate")
public class ServletBookingOfficeUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (BookingOfficeService bookingOfficeService = new BookingOfficeService();
             TripService tripService = new TripService()) {
            int id = Integer.parseInt(request.getParameter("id"));

            String officeName = request.getParameter("officeName");
            String destination = request.getParameter("destination");
            String officePhone = request.getParameter("officePhone");
            String officePlace = request.getParameter("officePlace");
            long officePrice = Long.parseLong(request.getParameter("officePrice"));
            Date startContractDeadline = Date.valueOf(request.getParameter("startContractDeadline"));
            Date endContractDeadline = Date.valueOf(request.getParameter("endContractDeadline"));

            Trip trip = tripService.getTripByNameService(destination);

            BookingOffice newBookingOffice = new BookingOffice(id, endContractDeadline, officeName, officePhone, officePlace, officePrice, startContractDeadline, trip.getTripId());
            boolean updated = bookingOfficeService.updateBookingOfficeService(newBookingOffice);

            if (updated){
                request.setAttribute("successMessage", "Update Success!");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletBookingOfficeViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
