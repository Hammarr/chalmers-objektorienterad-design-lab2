import java.awt.*;
import java.util.Stack;

enum RampState {
    Up, Down
}
public class CarTransport extends Car {
    private RampState rampStatus = RampState.Down;
    private Stack<Car> loadedCars = new Stack<>();
    private final int capacity = 100;
    private final int minDistanceToLoad = 5;
    private final int maxAllowedCarSize = 6;

    public CarTransport() {
        super("Car Transport", 2, 80, Color.BLUE, 10);
    }

    public void raise(){
        if(currentSpeed == 0)
            rampStatus = RampState.Up;
    }

    public void lower() {
        if(currentSpeed == 0)
            rampStatus = RampState.Down;
    }

    @Override
    public void gas(double amount){
        if(rampStatus == RampState.Down){super.gas(amount);}
    }
    @Override
    double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void move() {
        super.move();
        for (Car c : loadedCars) {
            c.setPositionX(getPositionX());
            c.setPositionY(getPositionY());
        }
    }
    @Override
    public void setPositionX(double x) {
        super.setPositionX(x);
        for (Car c : loadedCars) {
            c.setPositionX(x);
        }
    }
    @Override
    public void setPositionY(double y) {
        super.setPositionY(y);
        for (Car c : loadedCars) {
            c.setPositionY(y);
        }
    }


    void loadCar(Car car) {
        boolean allowed = rampStatus == RampState.Down &&
                          loadedCars.size() < capacity &&
                          car.size <= maxAllowedCarSize &&
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
        loadedCars.add(car);
    }

    void unloadCar() {
        if (rampStatus != RampState.Down) {
            return;
        }
        Car car = loadedCars.pop();
        car.setPositionX(getPositionX() + 5);
        car.setPositionY(getPositionY());
    }
}
