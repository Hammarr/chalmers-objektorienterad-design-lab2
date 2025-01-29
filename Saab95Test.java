import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 car;
    @BeforeEach
    public void setUptest () {
        car = new Saab95();
    }

    @Test
    void speedFactor() {
        car.setTurboOn();
        double a = car.speedFactor();
        car.setTurboOff();
        double b = car.speedFactor();
        assertTrue(a > b);
    }
}