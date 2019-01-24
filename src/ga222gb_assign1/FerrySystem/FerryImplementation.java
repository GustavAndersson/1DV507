package ga222gb_assign1.FerrySystem;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryImplementation implements Ferry{
    private ArrayList<Passenger> passengers = new ArrayList<>();    //Array to store all passengers
    private ArrayList<Vehicle> vehicles = new ArrayList<>();        //Array to store all vehicles
    private int vehicleSpace = 0;                                   //Used vehicle space - max 200
    private int money = 0;                                          //Money earned

    public Iterator<Vehicle> iterator(){
        return vehicles.iterator();
    }   //Return vehicle iterator

    public int countPassengers(){
        return passengers.size();
    }           //Return number of embarked passengers

    public int countVehicleSpace(){
        return vehicleSpace;
    }              //Return number of used vehicle space

    public int countMoney(){
        return money;
    }                           //Return number of earned money

    public void embark(Vehicle v){                                      //Method that embarks a vehicle if there is enough space
        if(hasSpaceFor(v)){                                             //for both the vehicle and passengers
            if(v.passengers.size() + passengers.size() <= 200){
                vehicles.add(v);
                v.setEmbarked(true);
                vehicleSpace += v.size;
                money += v.totalCost;

                for(int i = 0; i < v.passengers.size(); i++){
                    passengers.add(v.passengers.get(i));
                    v.passengers.get(i).setEmbarked(true);
                }
            }
        }
    }

    public void embark(Passenger p){    //Method that embarks a passenger if there is enough space
        if(hasRoomFor(p)){
            p.setEmbarked(true);
            money += p.getCost();
            passengers.add(p);
        }
    }

    public void disembark(){    //Method that disembark everything
        passengers.clear();
        vehicles.clear();
        vehicleSpace = 0;
    }

    public boolean hasSpaceFor(Vehicle v){  //Method that checks if there is enough space for a vehicle
        if(!v.isEmbarked()){
            if(v.size + vehicleSpace <= 200){
                return true;
            }else{
                System.out.println("There is no room for more vehicles");
                return false;
            }
        }else{
            System.out.println("Vehicle already embarked");
            return false;
        }
    }

    public boolean hasRoomFor(Passenger p){     //Method that checks if there is enough space for a passenger
        if(!p.isEmbarked()){
            if(passengers.size() < 200){
                return true;
            }
            else{
                System.out.println("There is no room for more passengers");
                return false;
            }
        }else{
            System.out.println("Passenger already embarked");
            return false;
        }
    }

    public String toString(){   //Prints some current Ferry-info
        String info = "----Ferry info----" + "\n"
                + "Passengers: " + countPassengers() + "\n"
                + "Vehicle space: " + countVehicleSpace() + "\n"
                + "Earned money: " + countMoney() + "\n";
        return info;
    }
}
