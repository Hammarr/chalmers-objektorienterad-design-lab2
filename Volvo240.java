import java.awt.*;

public class Volvo240{

    public final static double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	color = clr;
    }

    public void startEngine(){
	currentSpeed = 0.1;
    }

    public void stopEngine(){
	currentSpeed = 0;
    }
    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        //assert(currentSpeed >= 0 && currentSpeed <= enginePower);
    }

    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        //assert(currentSpeed >= 0 && currentSpeed <= enginePower);
    }
}
