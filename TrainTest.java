import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TrainTest {

    public Engine myEngine;
    public Car c1;
    public Car c2;
    public Car c3;
    public Train myTrain;

    @Before //prework before every test
    public void setup() {
        this.myEngine = new Engine(FuelType.ELECTRIC, 100., 100.);
        this.c1 = new Car(5);
        this.c2 = new Car(1);
        this.c3 = new Car(1);
        this.myTrain = new Train(FuelType.ELECTRIC, 100., 3, 2);
    }

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        //FuelType testFuelType = FuelType.ELECTRIC;
        //double testCurrentLevel = 100;
        //double testMaxFuelLevel = 100;
        FuelType expectedFuelType = FuelType.ELECTRIC;
        double expectedCurrentLevel = 100.;
        double expectedMaxLevel = 100.;
        assertEquals(expectedFuelType, myEngine.getFuelType());
        assertEquals(expectedCurrentLevel, myEngine.getCurrentFuel(), .001);
        assertEquals(expectedMaxLevel, myEngine.getMaxFuel(), .001);
    }

    @Test
    public void testEngineGo() {
        //double testFuelLevel = 10;
        //boolean currentFuelChangeResult = true;
        //assertEquals(currentFuelChangeResult, myEngine.go());
        myEngine.go();
        assertEquals(90, myEngine.currentFuelLevel, .001); //changed currentFuelLevel attribute from private to public
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger p1 = new Passenger("Caitlyn");
        c1.addPassenger(p1);
        assertEquals(1, c1.passengersOnboard.size()); //changed passengersOnboard attribute from private to public
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger p1 = new Passenger("Caitlyn");
        c2.addPassenger(p1);
        c2.removePassenger(p1);
        //assertTrue(testPassengerRemoveResult);
        //assertEquals(0, myCarTwo.passengersOnboard.size()); //changed passengersOnboard attribute from private to public
        c2.removePassenger(p1);
        assertEquals(0, c2.passengersOnboard.size()); //checks if passenger count doesn't go negative
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p2 = new Passenger("Jenica");
        p2.boardCar(c1);
        assertTrue(c1.passengersOnboard.contains(p2));
    }

    @Test
    public void testPassengerBoardCarFull() {
        Passenger p2 = new Passenger("Jenica");
        p2.boardCar(c3);
        p2.boardCar(c3);
        assertTrue(c3.passengersOnboard.contains(p2)); //is this right, Jenica would still be on car?
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        int myTrainCarNum = myTrain.cars.size(); //made ArrayList cars public
        assertEquals(3, myTrainCarNum);
    }

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


        int totalPassengerCount = myTrain.getMaxCapacity() - myTrain.seatsRemaining(); //gets total number of passengers seated on train
        assertEquals(1, totalPassengerCount);
        //assertEquals();
    }

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

        assertEquals(2, myTrainC1.getCapacity());
        assertEquals(1, myTrainC1.seatsRemaining());

        assertEquals(2, myTrainC2.getCapacity());
        assertEquals(0, myTrainC2.seatsRemaining());
    }

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
        myTrainC1P3.getOffCar(myTrainC1);

        myTrainC2P1.boardCar(myTrainC2);
        myTrainC2P2.boardCar(myTrainC2);

        myTrainC3P1.boardCar(myTrainC3);

        assertTrue(myTrain.printManifest().contains("Esther"));
    }
    
}
