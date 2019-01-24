package ga222gb_assign1.FerrySystem;

import java.util.ArrayList;

public abstract class Vehicle {
    private boolean isEmbarked = false; //If the vehicle is embarked
    protected int size;                 //Size of the vehicle
    protected int totalCost;            //Total cost for the vehicle + passengers
    protected VehicleType vehicleType;  //What type of vehicle it is
    protected ArrayList<Passenger> passengers = new ArrayList<>(); //ArrayList that stores all passengers

    public boolean isEmbarked(){
        return isEmbarked;
    }

    public void setEmbarked(boolean embarked){
        this.isEmbarked = embarked;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    protected enum VehicleType{ //All vehicle types
        car,
        bicycle,
        bus,
        lorry
    }
}
