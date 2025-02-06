import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;
    @BeforeEach
    public void setUptest () {
        scania = new Scania();
    }


    @Test
    void raise() {
        scania.raise(10);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }

    @Test
    void lower() {
        scania.raise(10);
        scania.lower(70000);
        scania.gas(1);
        assertTrue(scania.getCurrentSpeed() > 0);
    }
}