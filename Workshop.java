import java.util.ArrayList;

public class Workshop<CarType extends Vehicle> {
    ArrayList<CarType> carsInWorkshop = new ArrayList<>();
    final int capacity;

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    public void giveCar(CarType car) {
        if (carsInWorkshop.size() < capacity && !carsInWorkshop.contains(car)) {
            this.carsInWorkshop.add(car);
        }
    }

    public CarType returnCar(CarType car) {
        if(carsInWorkshop.removeIf(n -> n == car)) {
            return car;
        }
        return null;
    }

}
