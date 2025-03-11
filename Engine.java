/**
 * Represents a train's engine with fuel requirements and abilities
 */
public class Engine implements EngineRequirements {
    
    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel = 200;
    
    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel Engine's max fuel level
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * @return fuel type used by this engine
     */
    public FuelType getFuelType(){
        return this.f;
    }

    /**
     * @return max fuel level of this engine 
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
        //returning maxfuel from attribute maxFuelLevel
        //can set maxFuelLevel attribute whatever you want
    }

    /**
     * @return current fuel level in this engine
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    /**
     * refuels engine to max fuel level which is set to 200
     */
    public void refuel(){
       this.currentFuelLevel = maxFuelLevel; 
    }

    /**
     * tries to move train, consumes fuel by decrements of 10
     * @return true if enough fuel to move after decrement, else false
     */
    public Boolean go(){
        double increment = 10;
        //engine can decrease in fuel by whatever increment you want
        //add bounds to ensure fuel doesn't go negative
        
        if (this.currentFuelLevel >= increment) {
            this.currentFuelLevel -= increment;
        
        } else {
            this.currentFuelLevel = 0; //adds bounds so currentFuelLevel doesn't become negative
        }

        System.out.println("The current fuel level is: " + this.currentFuelLevel); // prints currentFuelLevel for both cases

        return this.currentFuelLevel > 0; //returns True if currentFuelLevel is > 0 after decreasing fuel and False otherwise

    }

    /**
     * @return String representation of engine's fuel details/status
     */
    public String toString(){
        return ("Engine has fuel type: " + this.f + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel);
    }

    // public static void main(String[] args){
    //     Engine myEngine = new Engine(FuelType.ELECTRIC, 100., 100.);
    //     System.out.println(myEngine);
    //     //by default when we print an object we get its location rather than the content inside it
    //     Engine myOtherEngine = new Engine(FuelType.STEAM, 50., 100.);
    //     System.out.println(myOtherEngine);
    //     while (myEngine.go()) {
    //         System.out.println("Choo choo!");
    //     }
    //     System.out.println("Out of fuel.");
    // }
}