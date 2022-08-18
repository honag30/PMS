package fa.trainning.controller.ticketServlet;

import fa.trainning.entities.Ticket;
import fa.trainning.services.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletTicketViewAll", value = "/ServletTicketViewAll")
public class ServletTicketViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            List<Ticket> listTicket = ticketService.viewAllTicketService();
            request.setAttribute("listTicket", listTicket);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/ticket-views/ticket-view-all.jsp");
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
