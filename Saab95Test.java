import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Volvo240 car;
    @BeforeEach
    public void setUptest () {
        car = new Volvo240();
    }

    @Test
    void incrementSpeed() {
        assertEquals(0, car.currentSpeed);
        double previousSpeed = car.currentSpeed;
        car.incrementSpeed(10);
        assertTrue(car.currentSpeed > previousSpeed);
    }

    @Test
    void decrementSpeed() {
        assertEquals(0, car.currentSpeed);
        car.incrementSpeed(100);
        double previousSpeed = car.currentSpeed;
        car.decrementSpeed(50);
        assertTrue(car.currentSpeed < previousSpeed);
    }
}