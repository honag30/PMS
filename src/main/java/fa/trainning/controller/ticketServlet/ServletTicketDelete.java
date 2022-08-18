package fa.trainning.controller.ticketServlet;

import fa.trainning.services.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTicketDelete", value = "/ServletTicketDelete")
public class ServletTicketDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (TicketService ticketService = new TicketService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean deleted= ticketService.deleteTicketService(id);
            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            } else {
                request.setAttribute("warningMessage", "Delete Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletTicketViewAll");
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
