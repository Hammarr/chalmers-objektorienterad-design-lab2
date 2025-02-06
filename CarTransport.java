import java.awt.*;
import java.util.Stack;

enum RampState {
    Up, Down
}
public class CarTransport extends TruckWithTrailer {
    private RampState rampStatus = RampState.Down;
    private Stack<CarTransportTransportable> loadedObjects = new Stack<>();
    private final int capacity = 100;
    private final int minDistanceToLoad = 5;

    public CarTransport() {
        super("Car Transport", 2, 80, Color.BLUE);
    }

    public void raise(){
        if(currentSpeed == 0){
            rampStatus = RampState.Up;
            allowedToDrive = false;}
    }

    public void lower() {
        if(currentSpeed == 0){
            rampStatus = RampState.Down;
            allowedToDrive = true;}
    }

    @Override
    double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void move() {
        super.move();
        for (CarTransportTransportable c : loadedObjects) {
            c.setPositionX(getPositionX());
            c.setPositionY(getPositionY());
        }
    }
    @Override
    public void setPositionX(double x) {
        super.setPositionX(x);
        for (CarTransportTransportable c : loadedObjects) {
            c.setPositionX(x);
        }
    }
    @Override
    public void setPositionY(double y) {
        super.setPositionY(y);
        for (CarTransportTransportable c : loadedObjects) {
            c.setPositionY(y);
        }
    }


    void loadCar(CarTransportTransportable car) {
        boolean allowed = rampStatus == RampState.Down &&
                          loadedObjects.size() < capacity &&
                          !(car instanceof CarTransport);
        if (!allowed) {
            return;
        }
        double distanceX = car.getPositionX() - getPositionX();
        double distanceY = car.getPositionY() - getPositionY();
        double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
        if (distance > minDistanceToLoad) {
            return;
        }
        loadedObjects.add(car);
    }

    CarTransportTransportable unloadCar() {
        if (rampStatus != RampState.Down) {
            return null;
        }
        CarTransportTransportable car = loadedObjects.pop();
        car.setPositionX(getPositionX() + 5);
        car.setPositionY(getPositionY());
        return car;
    }
}
