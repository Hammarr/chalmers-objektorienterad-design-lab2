/*import java.awt.*;

abstract class Truck extends Car {
    boolean harLast = false;
    double angle = 0;
    double degree = 0;
    public Truck(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color);
    }

    public void raise(double angle) {
        if (currentSpeed == 0 & harLast) {
            this.degree = Math.min(70, angle + degree);
        }
    }
    public void lower(double angle) {
        if (currentSpeed == 0 & harLast) {
            this.degree = Math.max(0, angle - degree);
        }
    }
    @Override
    public void gas(double amount){
        if(degree == 0){super.gas(amount);}
    }

}
*/