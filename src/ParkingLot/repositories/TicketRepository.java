package ParkingLot.repositories;

import ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private long previousID = 0;
    public Ticket saveTicket(Ticket ticket){
        previousID += 1;
        ticket.setId(previousID);
        tickets.put(previousID , ticket);
        return ticket;
    }
}
