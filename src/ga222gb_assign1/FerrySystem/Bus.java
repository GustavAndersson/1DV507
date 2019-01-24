package ga222gb_assign1.FerrySystem;

public class Bus extends Vehicle {

    public Bus(int p){              //Bus constructor
        if(p >= 1 && p <= 20){      //Must be between 1 and 20 passengers
            for(int i = 0; i < p; i++){
                passengers.add(new Passenger());
            }
            size = 20;
            totalCost = 200 + (p * 10);
            vehicleType = VehicleType.bus;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
