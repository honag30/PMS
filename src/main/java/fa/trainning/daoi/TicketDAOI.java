package fa.trainning.daoi;

import fa.trainning.entities.Ticket;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TicketDAOI {
    boolean createTicket(Ticket ticket) throws SQLException, ParseException;
    List<Ticket> viewAllTicket() throws SQLException, ParseException;
    List<Ticket> searchTicket(String key, int id) throws SQLException, ParseException;
    boolean editTicket(Ticket ticket) throws SQLException, ParseException;
    boolean deleteTicket(int id) throws SQLException, ParseException;
    Ticket getTicketById(long id) throws SQLException, ParseException;
    Ticket getTicketByName(String name) throws SQLException, ParseException;
    boolean updateTicket(Ticket ticket) throws SQLException, ClassNotFoundException;
    long getNumberOfBookedTicket(long id) throws SQLException, ClassNotFoundException;

}
