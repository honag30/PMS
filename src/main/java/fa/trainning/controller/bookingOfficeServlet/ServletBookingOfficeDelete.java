package fa.trainning.controller.bookingOfficeServlet;

import fa.trainning.services.BookingOfficeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletBookingOfficeDelete", value = "/ServletBookingOfficeDelete")
public class ServletBookingOfficeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (BookingOfficeService bookingOfficeService = new BookingOfficeService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean deleted = bookingOfficeService.deleteBookingOfficeService(id);

            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletBookingOfficeViewAll");
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
