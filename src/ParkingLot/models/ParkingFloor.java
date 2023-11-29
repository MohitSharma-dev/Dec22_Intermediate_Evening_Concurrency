package ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<ParkingSlot> parkingSlotsList;
    private List<VehicleTypes> allowedVehicleTypes;
    private ParkingFloorStatus parkingFloorStatus;
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotsList() {
        return parkingSlotsList;
    }

    public void setParkingSlotsList(List<ParkingSlot> parkingSlotsList) {
        this.parkingSlotsList = parkingSlotsList;
    }
}
