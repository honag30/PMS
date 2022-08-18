package fa.trainning.controller.ticketServlet;

import fa.trainning.entities.Ticket;
import fa.trainning.services.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTicketGetById", value = "/ServletTicketGetById")
public class ServletTicketGetById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            Ticket ticket = ticketService.getTicketByIdService(id);
            request.setAttribute("ticket", ticket);

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
