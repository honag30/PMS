package fa.trainning.controller.bookingOfficeServlet;

import fa.trainning.entities.BookingOffice;
import fa.trainning.services.BookingOfficeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletBookingOfficeGetById", value = "/ServletBookingOfficeGetById")
public class ServletBookingOfficeGetById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (BookingOfficeService bookingOfficeService = new BookingOfficeService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            BookingOffice bookingOffice = bookingOfficeService.getBookingOfficeByIdService(id);
            request.setAttribute("bookingOffice", bookingOffice);

            RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/assets/views/book-office-views/book-office-form.jsp");
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
