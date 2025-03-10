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
        double myTrainCarNum = myTrain.cars.size(); //made ArrayList cars public
        assertEquals(3, myTrainCarNum, .001);
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
