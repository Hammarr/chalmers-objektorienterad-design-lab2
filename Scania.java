import java.awt.*;

public class Scania extends Car {

    double trailerDegree = 0;

    public Scania() {
        super("Volvo", 2, 100, Color.GREEN);
    }

    public void raise(double angle) {
        if (currentSpeed == 0) {
            this.trailerDegree = Math.min(70, angle + trailerDegree);
        }
    }
    public void lower(double angle) {
        if (currentSpeed == 0) {
            this.trailerDegree = Math.max(0, angle - trailerDegree);
        }
    }
    @Override
    public void gas(double amount){
        if(trailerDegree == 0){super.gas(amount);}
    }
    @Override
    double speedFactor() {
        return enginePower * 0.01;
    }

}
