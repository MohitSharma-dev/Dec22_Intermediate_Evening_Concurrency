package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {

    public Optional<Vehicle> getVehicleByNumber(String vehicleNumber)
    {
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){

        return vehicle;
    }
}
