class Vehicle {
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
class Slot {
    int slotId;
    Vehicle vehicle;

    Slot(int slotId) {
        this.slotId = slotId;
        this.vehicle = null;
    }

    boolean isEmpty() {
        return vehicle == null;
    }

    void park(Vehicle v) {
        if (v == null) {
            System.out.println("Cannot park null vehicle");
            return;
        }
        this.vehicle = v;
    }

    void remove() {
        this.vehicle = null;
    }
}
class ParkingLot {
    private Slot[] slots;

    ParkingLot(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Parking lot size must be greater than 0");
        }

        slots = new Slot[size];
        for (int i = 0; i < size; i++) {
            slots[i] = new Slot(i);
        }
    }
    void parkVehicle(Vehicle v) {
        if (v == null) {
            System.out.println("Invalid vehicle!");
            return;
        }
        for (Slot slot : slots) {
            if (slot.isEmpty()) {
                slot.park(v);
                System.out.println("Vehicle " + v.vehicleNumber + " parked at slot " + slot.slotId);
                return;
            }
        }
        System.out.println("Parking Full!");
    }
    void removeVehicle(int slotId) {
        if (slotId < 0 || slotId >= slots.length) {
            System.out.println("Invalid slot number!");
            return;
        }
        Slot slot = slots[slotId];
        if (!slot.isEmpty()) {
            System.out.println("Vehicle " + slot.vehicle.vehicleNumber + " removed from slot " + slotId);
            slot.remove();
        } else {
            System.out.println("Slot already empty!");
        }
    }
    void display() {
        System.out.println("\nParking Lot Status:");
        for (Slot slot : slots) {
            if (slot.isEmpty()) {
                System.out.println("Slot " + slot.slotId + " → Empty");
            } else {
                System.out.println("Slot " + slot.slotId + " → " + slot.vehicle.vehicleNumber);
            }
        }
    }
}
public class main {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(5);

        Vehicle v1 = new Vehicle("TN01A1234");
        Vehicle v2 = new Vehicle("TN02B5678");
        Vehicle v3 = new Vehicle("TN03C9999");

        lot.parkVehicle(v1);
        lot.parkVehicle(v2);
        lot.parkVehicle(v3);

        lot.display();

        lot.removeVehicle(1);

        lot.display();

        lot.parkVehicle(new Vehicle("TN04D7777"));

        lot.display();
    }
}
