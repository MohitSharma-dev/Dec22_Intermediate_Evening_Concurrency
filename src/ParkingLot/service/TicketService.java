package ParkingLot.service;

import ParkingLot.Exceptions.GateNotFoundException;
import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                  ParkingLotRepository parkingLotRepository,
                  TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(
            String vehicleNumber,
            String vehicleOwnerName,
            VehicleTypes vehicleType,
            Long gateId){
        // 1. Create a Ticket obj
        // 2. Assign a spot
        // 3. return the ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        // Setting the Gate
        Optional<Gate> gateOptional= gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // Setting the vehicle
        Vehicle savedVehicle;
        Optional<Vehicle> vehicleOptional =  vehicleRepository.getVehicleByNumber(vehicleNumber);
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);


        // Assign the slot
        SlotAssignmentStrategyType slotAssignmentStrategyType =  parkingLotRepository
                .getParkingLotByGate(gate)
                .getSlotAssignmentStrategyType();
        ParkingSlot parkingSlot =  SlotAssignmentStrategyFactory
                .getSlotForType(slotAssignmentStrategyType)
                .getSlot(gate, vehicleType);
        ticket.setParkingSlot(parkingSlot);

        ticket = ticketRepository.saveTicket(ticket);
        ticket.setNumber("TICKET - " + ticket.getId());
        return ticket;
    }
}
