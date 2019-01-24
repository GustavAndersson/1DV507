package ga222gb_assign1.FerrySystem;

public class Car extends Vehicle {
    public Car(int p){              //Car constructor
        if(p >= 1 && p <= 4){       //Must be between 1 and 4 passengers
            for(int i = 0; i < p; i++){
                passengers.add(new Passenger());
            }
            size = 5;
            totalCost = 100 + (p * 15);
            vehicleType = VehicleType.car;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
