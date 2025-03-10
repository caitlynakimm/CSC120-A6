import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TrainTest {

    public Engine myEngine;

    @Before //prework before every test
    public void setup() {
        this.myEngine = new Engine(FuelType.ELECTRIC, 100., 100.);
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
        boolean currentFuelChangeResult = true;
        assertEquals(currentFuelChangeResult, myEngine.go());
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        fail();
    }

    @Test
    public void testCarRemovePassenger() {
        fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        fail();
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
