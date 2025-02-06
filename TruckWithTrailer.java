import java.awt.*;

abstract class TruckWithTrailer extends Vehicle {
    protected boolean allowedToDrive = true;

    public TruckWithTrailer(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color);
    }
    @Override
    public void gas(double amount){
        if(allowedToDrive){super.gas(amount);}
    }

}