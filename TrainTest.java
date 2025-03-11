import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test for the train simulation
 * Contains unit tests for method functionality in the Engine, Car, Passenger, and Train classes
 */
public class TrainTest {

    public Engine myEngine;
    public Car c1;
    public Car c2;
    public Car c3;
    public Train myTrain;

    /**
     * Creates an electric engine, three cars with different capacities, and a train with electric engine and 3 cars
     */
    @Before //prework before every test
    public void setup() {
        this.myEngine = new Engine(FuelType.ELECTRIC, 100., 100.);
        this.c1 = new Car(5);
        this.c2 = new Car(1);
        this.c3 = new Car(1);
        this.myTrain = new Train(FuelType.ELECTRIC, 100., 3, 2);
    }

    // Engine Tests
    /**
     * Tests Engine constructor
     * Verifies that Engine object is initialized with correct fuel type, current fuel level, and maximum fuel capacity
     */
    @Test
    public void testEngineConstructor() {
        FuelType expectedFuelType = FuelType.ELECTRIC;
        double expectedCurrentLevel = 100.;
        double expectedMaxLevel = 100.;
        assertEquals(expectedFuelType, myEngine.getFuelType());
        assertEquals(expectedCurrentLevel, myEngine.getCurrentFuel(), .001);
        assertEquals(expectedMaxLevel, myEngine.getMaxFuel(), .001);
    }

    /**
     * Tests Engine's go method
     * Verifies calling go() reduces current fuel level by the expected increment
     */
    @Test
    public void testEngineGo() {
        myEngine.go();
        assertEquals(90, myEngine.getCurrentFuel(), .001);
    }

    // Car Tests
    /**
     * Tests Car's addPassenger method
     * Verifies adding a passenger to a car decreases seats remaining
     */
    @Test
    public void testCarAddPassenger() {
        Passenger p1 = new Passenger("Caitlyn");
        c1.addPassenger(p1);
        assertEquals(4, c1.seatsRemaining());
    }

    /**
     * Tests Car's removePassenger method
     * Verifies that passenger can be removed from a car, 
     * trying to remove a passenger who isn't on the car won't create negative counts,
     * and that method returns false when trying to remove a passenger who isn't boarded
     */
    @Test
    public void testCarRemovePassenger() {
        Passenger p1 = new Passenger("Caitlyn");
        c2.addPassenger(p1);
        c2.removePassenger(p1);
        c2.removePassenger(p1);
        assertEquals(0, c2.passengersOnboard.size()); //checks if passenger count doesn't go negative
        assertFalse(c2.removePassenger(p1));
    }

    // Passenger Tests
    /**
     * Tests passenger boarding car with available seats
     * Verifies that passenger is successfully added to car's passenger list
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p2 = new Passenger("Jenica");
        p2.boardCar(c1);
        assertTrue(c1.passengersOnboard.contains(p2));
    }

    /**
     * Tests passenger boarding a car that's already full
     * Verifies that passenger attempting to board is rejected and car correctly reports having zero remaining seats
     */
    @Test
    public void testPassengerBoardCarFull() {
        Passenger p2 = new Passenger("Jenica");

        p2.boardCar(c3);
        assertTrue(c3.passengersOnboard.contains(p2)); //confirms Jenica is onboard car 3
        
        Passenger p3 = new Passenger("Mary");
        p3.boardCar(c3);
        assertFalse(c3.passengersOnboard.contains(p3)); //confirms Mary is not onboard car 3 since it is full
        assertEquals(0, c3.seatsRemaining()); //confirms car 3 is full or has no seats

    }

    // Train Tests
    /**
     * Tests Train constructor
     * Verifies that train is properly initialized with specified number of cars
     */
    @Test
    public void testTrainConstructor() {
        int myTrainCarNum = myTrain.cars.size(); //made ArrayList cars public
        assertEquals(3, myTrainCarNum);
    }

    /**
     * Tests Train's passenger counting functionality
     * Simulates scenarios of passengers boarding and leaving
     * Verifies train correctly reports total number of passengers
     */
    @Test
    public void testTrainPassengerCount() {
        Passenger myTrainC1P1 = new Passenger("Esther");
        Passenger myTrainC1P2 = new Passenger("Jhadia");
        Passenger myTrainC1P3 = new Passenger("Melissa");

        Car myTrainC1 = myTrain.getCar(0);

        myTrainC1P1.boardCar(myTrainC1);
        myTrainC1P2.boardCar(myTrainC1);
        myTrainC1P1.getOffCar(myTrainC1);
        myTrainC1P3.getOffCar(myTrainC1);


        Passenger myTrainC2P1 = new Passenger("Jayani");
        Passenger myTrainC2P2 = new Passenger("Joyce");

        Car myTrainC2 = myTrain.getCar(1);

        myTrainC2P1.boardCar(myTrainC2);
        myTrainC2P2.boardCar(myTrainC2);

        Passenger myTrainC3P1 = new Passenger("Kate");

        Car myTrainC3 = myTrain.getCar(2);

        myTrainC3P1.boardCar(myTrainC3);
        
        int totalPassengerCount = myTrain.getMaxCapacity() - myTrain.seatsRemaining(); //gets total number of passengers seated on train
        assertEquals(4, totalPassengerCount);
        //assertEquals();
    }

    /**
     * Tests Train's getCar method
     * Verifies that cars can be retrieved by index, cars have correct capacity and seats remaining, and
     * throws an IndexOutOfBoundsException when trying to access a car that doesn't exist
     */
    @Test
    public void testTrainGetCar() {
        Passenger myTrainC1P1 = new Passenger("Esther");
        Passenger myTrainC1P2 = new Passenger("Jhadia");
        Passenger myTrainC1P3 = new Passenger("Melissa");

        Car myTrainC1 = myTrain.getCar(0);

        Passenger myTrainC2P1 = new Passenger("Nazifa");
        Passenger myTrainC2P2 = new Passenger("Natalie");

        Car myTrainC2 = myTrain.getCar(1);

        myTrainC1P1.boardCar(myTrainC1);
        myTrainC1P2.boardCar(myTrainC1);
        myTrainC1P1.getOffCar(myTrainC1);
        myTrainC1P3.getOffCar(myTrainC1);

        myTrainC2P1.boardCar(myTrainC2);
        myTrainC2P2.boardCar(myTrainC2);

        assertNotNull(myTrain.getCar(0));
        assertEquals(2, myTrainC1.getCapacity());
        assertEquals(1, myTrainC1.seatsRemaining());

        assertEquals(2, myTrainC2.getCapacity());
        assertEquals(0, myTrainC2.seatsRemaining());

        try {
            myTrain.getCar(3);
            fail("throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Train does not have a fourth car.");
        }


    }

    /**
     * Tests Train's printManifest method
     * Simulates multiple scenarios of passengers boarding and leaving
     * Verifies manifest output correctly lists all cars and their passengers
     * Uses output stream capture to test console output for correct content and formatting
     */
    @Test
    public void testTrainPrintManifest() {
        Passenger myTrainC1P1 = new Passenger("Esther");
        Passenger myTrainC1P2 = new Passenger("Jhadia");
        Passenger myTrainC1P3 = new Passenger("Melissa");

        Car myTrainC1 = myTrain.getCar(0);

        Passenger myTrainC2P1 = new Passenger("Nazifa");
        Passenger myTrainC2P2 = new Passenger("Natalie");

        Car myTrainC2 = myTrain.getCar(1);

        Passenger myTrainC3P1 = new Passenger("Jina");

        Car myTrainC3 = myTrain.getCar(2);

        myTrainC1P1.boardCar(myTrainC1);
        myTrainC1P2.boardCar(myTrainC1);
        myTrainC1P1.getOffCar(myTrainC1);
        myTrainC1P2.getOffCar(myTrainC1);
        myTrainC1P3.getOffCar(myTrainC1);

        myTrainC2P1.boardCar(myTrainC2);
        myTrainC2P2.boardCar(myTrainC2);

        myTrainC3P1.boardCar(myTrainC3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();  //create buffer to capture console output
        PrintStream originalOut = System.out;  //save original System.out stream for restoration at end of test
        System.setOut(new PrintStream(outContent)); //redirect System.out to buffer

        try {
            myTrain.printManifest(); //generate train's manifest output
            String[] output = outContent.toString().split(System.lineSeparator()); //converts captured bytes/output to string and then splits output into lines

            //verify output contains roster title, car labels, and passengers (or none) boarded in cars
            assertTrue(output[0].contains("Roster of all passengers: "));
            
            assertTrue(output[1].contains("Car 1:"));
            assertTrue(output[2].contains("This car is EMPTY.")); //this message should print since train's first car has no passengers
            
            assertTrue(output[3].contains("Car 2:"));
            assertTrue(output[4].contains("Nazifa, Natalie")); //names would be in same ArrayList hence same line
            
            assertTrue(output[5].contains("Car 3:"));
            assertTrue(output[6].contains("Jina"));

        } finally {
            //cleanup
            System.setOut(originalOut); //restores original System.out regardless of test results
        }

        
    }
    
}
