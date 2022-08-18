package fa.trainning.services;

import fa.trainning.daoi.DAOFactory;
import fa.trainning.daoi.TicketDAOI;
import fa.trainning.entities.Ticket;
import fa.trainning.entities.Trip;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class TicketService implements AutoCloseable {


    private final TicketDAOI ticketDAO = DAOFactory.getNewTicketDAO();

    public boolean createTicketService(Ticket ticket)  throws SQLException, ParseException {
        return ticketDAO.createTicket(ticket);
    }
    public List<Ticket> viewAllTicketService()  throws SQLException, ParseException {
        return ticketDAO.viewAllTicket();
    }
    public List<Ticket> searchTicketService(String key, int id)  throws SQLException, ParseException {
        return ticketDAO.searchTicket(key, id);
    }

    public boolean editTicketService(Ticket ticket)  throws SQLException, ParseException {
        return ticketDAO.editTicket(ticket);
    }

    public boolean updateTicketService(Ticket ticket) throws SQLException, ParseException, ClassNotFoundException {
        return ticketDAO.updateTicket(ticket);
    }

    public boolean deleteTicketService(int id)  throws SQLException, ParseException {
        return ticketDAO.deleteTicket(id);
    }

    public Ticket getTicketByIdService(long id)  throws SQLException, ParseException{
        return ticketDAO.getTicketById(id);
    }

    public Ticket getTicketByNameService(String name)  throws SQLException, ParseException{
        return ticketDAO.getTicketByName(name);
    }

    public long getNumberOfBookedTicketService(long id) throws SQLException, ParseException, ClassNotFoundException {
        return ticketDAO.getNumberOfBookedTicket(id);
    }

    @Override
    public void close() throws Exception {

    }
}
