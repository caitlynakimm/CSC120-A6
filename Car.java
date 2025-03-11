import java.util.ArrayList;

/**
 * Represents one passenger car that can hold a limited number of passengers
 */
public class Car implements CarRequirements {
    
    //Attributes
    private int carSeatCapacity;
    private int remainingSeats;
    private ArrayList<Passenger> passengersOnboard; 

    /**
     * Constructor for Car
     * @param carSeatCapacity Car's maximum number of passengers it could hold
     */
    public Car(int carSeatCapacity){
        this.carSeatCapacity = carSeatCapacity;
        this.remainingSeats = carSeatCapacity; //remainingSeats starts with full seats in car
        this.passengersOnboard = new ArrayList<>();
    }

    /**
     * @return maximum passenger capacity for this car
     */
    public int getCapacity(){
        return this.carSeatCapacity;
    }

    /**
     * @return number of available seats in this car
     */
    public int seatsRemaining(){
        return this.remainingSeats;
    }

    /**
     * Tries to add a passenger to this car
     * @param p Passenger to add to array list passengersOnboard
     * @return true if passenger was successfully added to array list, else false if car is full
     */
    public Boolean addPassenger(Passenger p){
        if (this.remainingSeats > 0) {
            this.remainingSeats -= 1;
            System.out.println("There are " + this.remainingSeats + " remaining seats.");
            return passengersOnboard.add(p);
        } else {
            return false;
        }
    }

    /**
     * Tries to remove a passenger from this car
     * @param p Passenger to remove from array list
     * @return true if passenger was successfully removed, else false if passenger wasn't onboard
     */
    public Boolean removePassenger(Passenger p){
        if (this.passengersOnboard.contains(p)){
            this.remainingSeats += 1;
            System.out.println("There are " + this.remainingSeats + " remaining seats.");
            return passengersOnboard.remove(p);
        } else {
            return false;
        }
    }

    /**
     * Prints an array list of all passengers currently in this car
     */
    public void printManifest(){
        if (this.passengersOnboard.size() > 0) {
            System.out.println(this.passengersOnboard);
        } else {
            System.out.println("This car is EMPTY.");
        }
    }

    public boolean isOnboard(Passenger p){
        return this.passengersOnboard.contains(p); //returns whether specified passenger is onboard
    }

    public String getPassengers(){
        return this.passengersOnboard.toString(); //returns copy of passenger list as string
    }

    public int getPassengerCount(){
        return passengersOnboard.size(); //returns number of passengers onboard
    }

    /**
     * @return String representation of car's capacity status
     */
    public String toString(){
        return ("The car's maximum capacity is " + this.carSeatCapacity + " and the remaining number of seats is " + this.remainingSeats + ".");
    }

    // public static void main(String[] args){
    //     Car myCar = new Car(15);
    //     System.out.println(myCar);
    //     Car myOtherCar = new Car(0);
    //     System.out.println(myOtherCar);
    //     myCar.printManifest();
    //     myCar.printManifest();

    //     Passenger Caitlyn = new Passenger("Caitlyn");
    //     Passenger Bob = new Passenger("Bob");
    //     System.out.println(Caitlyn);
    //     myCar.addPassenger(Caitlyn);
    //     myCar.addPassenger(Bob);
    //     myCar.printManifest();
    //     myCar.removePassenger(Bob);
    //     myOtherCar.addPassenger(Bob);


    // }
}



