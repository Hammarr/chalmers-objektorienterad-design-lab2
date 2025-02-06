import java.awt.*;

public abstract class Car extends Vehicle implements CarTransportTransportable{
    public Car(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color);
    }
}
