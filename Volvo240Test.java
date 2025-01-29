import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    private Volvo240 car;
    @BeforeEach
    public void setUptest () {
        car = new Volvo240();
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.currentSpeed);
    }

    @Test
    void stopEngine() {
        car.startEngine();
        car.incrementSpeed(100);
        car.gas(0.4);
        car.stopEngine();
        assertEquals(0, car.currentSpeed);
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

    @Test
    void gas() {
        assertEquals(0, car.currentSpeed);
        double previousSpeed = car.currentSpeed;
        car.gas(0.5);
        car.gas(1);
        assertThrows(IllegalArgumentException.class, () -> {car.gas(2);});
        assertTrue(car.currentSpeed > previousSpeed);
    }

    @Test
    void brake() {
        assertEquals(0, car.currentSpeed);
        car.gas(0.5);
        double previousSpeed = car.currentSpeed;
        car.brake(0.25);
        assertThrows(IllegalArgumentException.class, () -> {car.brake(2);});
        assertTrue(car.currentSpeed < previousSpeed);
    }

    @Test
    void move() {
        assertEquals(Direction.NORTH, car.getCurrentDirection());
        car.startEngine();
        assertEquals(0.1, car.currentSpeed);
        assertEquals(0, car.getPositionX());
        assertEquals(0, car.getPositionY());
        car.move();
        assertEquals(0, car.getPositionX());
        assertEquals(0.1, car.getPositionY());
    }

    @Test
    void turnLeft() {
        assertEquals(Direction.NORTH, car.getCurrentDirection());
        car.turnLeft();
        assertEquals(Direction.WEST, car.getCurrentDirection());
        car.turnLeft();
        car.turnLeft();
        assertEquals(Direction.EAST, car.getCurrentDirection());
    }

    @Test
    void turnRight() {
        assertEquals(Direction.NORTH, car.getCurrentDirection());
        car.turnRight();
        assertEquals(Direction.EAST, car.getCurrentDirection());
    }
}