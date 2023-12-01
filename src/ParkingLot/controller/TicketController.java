package ParkingLot.controller;

import ParkingLot.dto.IssueTicketRequestDTO;
import ParkingLot.dto.IssueTicketResponseDTO;
import ParkingLot.dto.ResponseType;
import ParkingLot.models.Ticket;
import ParkingLot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleOwnerName(),
                    requestDTO.getVehicleType(),
                    requestDTO.getGateId());
            response.setTicket(ticket);
            response.setResponseStatus(ResponseType.SUCCESS);
        } catch (Exception e){
            response.setResponseStatus(ResponseType.FAILURE);
            response.setFailureMessage(e.getMessage());
        }


        return response;

    }
}

// 1. Needs to interact with client
// 2. Validations on the input
// 3. Call the service and provide it with the inputs
// 4. Receive the output from service and send it over to the client in a proper form
