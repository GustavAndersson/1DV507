package ga222gb_assign1.FerrySystem;

import java.util.Iterator;

public class FerryMain {

    public static void main(String[] args){

        Ferry ferry = new FerryImplementation();    //Create new ferry
        Vehicle lorry = new Lorry(2);           //Create a new lorry with 2 passengers
        ferry.embark(lorry);                       //Embark the lorry

        Vehicle car = new Car(4);               //Create car with 4 passengers
        ferry.embark(car);                         //Embark the car

        Vehicle bus = new Bus(20);              //Create bus with 20 passengers
        ferry.embark(bus);                        //Embark the bus

        Vehicle bicycle = new Bicycle();          //Create bicycle, standard 1 passenger
        ferry.embark(bicycle);                    //Embark the bicycle

        Passenger p = new Passenger();            //Create a single passenger
        ferry.embark(p);                          //Embark the passenger

        System.out.println(ferry.toString());     //Print ferry info

        Vehicle bus2 = new Bus(17);
        System.out.println(ferry.hasSpaceFor(bus2)); //Check if ferry has space for a bus and 17 passengers
        ferry.embark(bus2);
        ferry.embark(bus2); //Should printout that bus2 already is embarked

        System.out.println("Vehicles embarked: ");
        Iterator<Vehicle> vehicles = ferry.iterator(); //Iterate and printout all the embarked vehicles
        int counter = 1;
        while(vehicles.hasNext()){
            Vehicle v = vehicles.next();
            System.out.println(counter + ". " + v.getVehicleType());
            counter++;
        }

        ferry.disembark();  //Disembark the ferry

        System.out.println(ferry.toString());      //Print ferry info (should be emptied but kept the earned money)
    }
}
