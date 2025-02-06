import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    private CarTransport tr;

    @BeforeEach
    public void setUptest() {
        tr = new CarTransport();
    }

    @Test
    void raise() {
        tr.raise();
        tr.gas(1);
        assertEquals(0, tr.getCurrentSpeed());

    }

    @Test
    void lower() {
        tr.raise();
        tr.lower();
        tr.gas(1);
        assertTrue(tr.getCurrentSpeed() > 0);

    }

    @Test
    void move() {
        Car car1 = new Saab95();
        Car car2 = new Saab95();
        tr.loadCar(car1);
        tr.loadCar(car2);
        tr.gas(1);
        tr.move();
        assertTrue(tr.getPositionY() != 0 || tr.getPositionX() != 0);
        assertEquals(car1.getPositionY(), tr.getPositionY());
        assertEquals(car2.getPositionY(), tr.getPositionY());
        assertEquals(car1.getPositionX(), tr.getPositionX());
        assertEquals(car2.getPositionX(), tr.getPositionX());
    }

    @Test
    void loadCar() {
        Car car1 = new Saab95();
        Car car2 = new Saab95();
        Car car3 = new Volvo240();
        tr.loadCar(car1);
        tr.loadCar(car2);
        tr.loadCar(car3);
        assertEquals(car3, tr.unloadCar());
        assertEquals(car2, tr.unloadCar());
        assertEquals(car1, tr.unloadCar());
        assertThrows(EmptyStackException.class, () -> tr.unloadCar());
    }
}