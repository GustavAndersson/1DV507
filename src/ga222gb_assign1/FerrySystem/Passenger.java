package ga222gb_assign1.FerrySystem;

public class Passenger {
    private final int cost = 20;            //Cost for one passenger
    private boolean isEmbarked = false;     //If the passenger is embarked

    public int getCost() {
        return cost;
    }

    public boolean isEmbarked() {
        return isEmbarked;
    }

    public void setEmbarked(boolean embarked) {
        isEmbarked = embarked;
    }
}
