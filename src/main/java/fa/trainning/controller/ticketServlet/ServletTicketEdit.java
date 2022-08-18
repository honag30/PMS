package fa.trainning.controller.ticketServlet;

import fa.trainning.entities.Ticket;
import fa.trainning.entities.Ticket;
import fa.trainning.services.TicketService;
import fa.trainning.services.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTicketEdit", value = "/ServletTicketEdit")
public class ServletTicketEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            Ticket existingTicket = ticketService.getTicketByIdService(id);
            request.setAttribute("existingTicket", existingTicket);

            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/ticket-views/ticket-form.jsp");
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
