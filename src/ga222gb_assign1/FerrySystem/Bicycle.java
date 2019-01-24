package ga222gb_assign1.FerrySystem;

public class Bicycle extends Vehicle {

    public Bicycle(){ //Bicycle constructor
        totalCost = 40;
        size = 1;
        vehicleType = VehicleType.bicycle;
        passengers.add(new Passenger());
    }
}