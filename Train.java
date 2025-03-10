import java.util.ArrayList;

/**
 * Represents a whole train made up of an engine and a certain number of cars
 */
public class Train implements TrainRequirements{

    //Attributes
    Engine engine;
    public ArrayList<Car> cars;
    private FuelType fuelType;
    private double fuelCapacity;

    /**
     * Constructor for Train
     * @param fuelType Engine's fuel type
     * @param fuelCapacity Engine's maximum fuel capacity
     * @param nCars Number of cars in the train to create
     * @param passengerCapacity Seat capacity for each car
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.fuelType = fuelType;
        this.cars = new ArrayList<>();
        this.fuelCapacity = fuelCapacity;

        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * @return The train's engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Tries to move train using the engine
     * @return true if train moved successfully, else false if runs out of fuel
     */
    public Boolean go(){
        return this.engine.go(); //calls from class Engine the go() method
    }

    /**
     * Refuels train's engine to maximum capacity
     */
    public void refuel(){
        this.engine.refuel(); //calls from class Engine the refuel() method
    }

    /**
     * Retrieves a particular car by index
     * @param i Index of car to retrieve (index starts at 0)
     * @return Requested car
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * @return Total passenger capacity across all cars in train
     */
    public int getMaxCapacity(){
        int totalMaxCapacity = 0;

        for (Car car: this.cars){
            totalMaxCapacity += car.getCapacity();
        }
        return totalMaxCapacity;
    }

    /**
     * @return Total available seats across all cars in train
     */
    public int seatsRemaining(){
        int totalSeatsRemaining = 0;

        for (Car car: this.cars){
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * Prints list of passengers for all cars in train
     */
    public void printManifest(){
        System.out.println("Roster of all passengers: ");
        for (int i = 0; i < this.cars.size(); i++) {
            System.out.println("Car " + (i+1) + ":");
            this.getCar(i).printManifest();
        }
    }

    /**
     * @return String representation of train configuration
     */
    public String toString(){
        return ("The train is fuel type: " + this.fuelType + " that has a fuel capacity of: " + this.fuelCapacity + " which consists of " + this.cars.size() + " cars with an overall total passenger capacity of " + this.getMaxCapacity() + ".");
    }

    // public static void main(String[] args){
    //     Train myTrain = new Train(FuelType.ELECTRIC, 100., 3, 2);
    //     System.out.println(myTrain);
    //     System.out.println();

    //     Car car1 = myTrain.getCar(0);
    //     System.out.println("Car 1:");
    //     System.out.println("Maximum capacity is: " + car1.getCapacity() + ".");
    //     System.out.println("Seats remaining is: " + car1.seatsRemaining() + ".");
    //     System.out.println();

    //     Passenger car1Passenger1 = new Passenger("Emma");
    //     Passenger car1Passenger2 = new Passenger("John Cena");
    //     Passenger car1Passenger3 = new Passenger("Mitski");
    //     car1Passenger1.boardCar(car1);
    //     car1Passenger2.boardCar(car1);
    //     car1Passenger3.boardCar(car1);
    //     car1Passenger3.getOffCar(car1);

    //     System.out.println();

    //     System.out.println("Roster for Car 1:");
    //     car1.printManifest();
    //     System.out.println();

    //     /////// 
    //     Car car2 = myTrain.getCar(1);
    //     System.out.println("Car 2:");
    //     System.out.println("Maximum capacity is: " + car2.getCapacity() + ".");
    //     System.out.println("Seats remaining is: " + car2.seatsRemaining() + ".");
    //     System.out.println();

    //     Passenger car2Passenger1 = new Passenger("Mary");
    //     Passenger car2Passenger2 = new Passenger("Jhadia");
    //     Passenger car2Passenger3 = new Passenger("Mark");

    //     car2Passenger1.boardCar(car2);
    //     car2Passenger2.boardCar(car2);
    //     car2Passenger3.getOffCar(car2);

    //     System.out.println();
        
    //     System.out.println("Roster for Car 2:");
    //     car2.printManifest();
    //     System.out.println();

    //     while (myTrain.go()) {
    //         System.out.println("Choo choo!");
    //     }
    //     System.out.println("Out of fuel.");
        
    //     myTrain.refuel();
    //     System.out.println("Train is refueled. Current fuel level: " + myTrain.getEngine().getCurrentFuel() + ".");

    //     System.out.println();
    //     System.out.println("The train's total maximum capacity is: " + myTrain.getMaxCapacity() + ".");
    //     System.out.println("The train's total seats remaining is: " + myTrain.seatsRemaining() + ".");
    //     System.out.println();
    //     myTrain.printManifest();
    // }
}
