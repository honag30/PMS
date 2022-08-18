package fa.trainning.controller.bookingOfficeServlet;

import fa.trainning.entities.BookingOffice;
import fa.trainning.services.BookingOfficeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletBookingOfficeViewAll", value = "/ServletBookingOfficeViewAll")
public class ServletBookingOfficeViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (BookingOfficeService bookingOfficeService = new BookingOfficeService()) {
            List<BookingOffice> listBookingOffice = bookingOfficeService.viewAllBookingOfficeService();
            request.setAttribute("listBookingOffice", listBookingOffice);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/booking-office-views/booking-office-view-all.jsp");
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
