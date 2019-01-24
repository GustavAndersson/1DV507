package ga222gb_assign1.FerrySystem;

public class Lorry extends Vehicle {

    public Lorry(int p){          //Lorry constructor
        if(p >= 1 && p <= 2){     //Must be 1 or 2 passengers
            for(int i = 0; i < p; i++){
                passengers.add(new Passenger());
            }
            size = 40;
            totalCost = 300 + (p * 15);
            vehicleType = VehicleType.lorry;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
