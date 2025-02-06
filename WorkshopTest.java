import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkshopTest {
    private Workshop<Saab95> workshop;
    @BeforeEach
    public void setUptest () {
        workshop = new Workshop<Saab95>(10);
    }


    @Test
    void giveCar() {
        Saab95 car = new Saab95();
        workshop.giveCar(car);
        assertSame(workshop.returnCar(car), car);
    }

    @Test
    void returnCar() {
        Saab95 car = new Saab95();
        Saab95 car2 = new Saab95();
        workshop.giveCar(car);
        workshop.giveCar(car2);
        assertSame(workshop.returnCar(car2), car2);

    }
}
