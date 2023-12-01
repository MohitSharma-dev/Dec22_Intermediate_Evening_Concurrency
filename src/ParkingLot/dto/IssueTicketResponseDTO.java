package ParkingLot.dto;

import ParkingLot.models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseType responseStatus;
    private String failureMessage;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseType getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseType response) {
        this.responseStatus = response;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
