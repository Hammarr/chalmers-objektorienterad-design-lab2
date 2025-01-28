import java.awt.*;

enum Direction {
    NORTH, SOUTH, WEST, EAST
}

abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    private Direction currentDirection = Direction.NORTH;
    private double positionX = 0;
    private double positionY = 0;

    public Car() {
        stopEngine();
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public int getNrDoors () {
        return nrDoors;
    }

    public double getEnginePower () {
        return enginePower;
    }

    public double getCurrentSpeed () {
        return currentSpeed;
    }

    public Color getColor () {
        return color;
    }

    public void setColor (Color clr){
        color = clr;
    }

    public void startEngine () {
        currentSpeed = 0.1;
    }

    public void stopEngine () {
        currentSpeed = 0;
    }

    protected void incrementSpeed(double amount) {}

    protected void decrementSpeed(double amount) {}

    public void gas(double amount){
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }

    public void move() {
        switch (currentDirection) {
            case NORTH -> positionY += currentSpeed;
            case SOUTH -> positionY -= currentSpeed;
            case WEST -> positionX -= currentSpeed;
            case EAST -> positionX += currentSpeed;
        }
    }

    public void turnLeft() {
        switch (currentDirection) {
            case NORTH -> currentDirection = Direction.WEST;
            case SOUTH -> currentDirection = Direction.EAST;
            case WEST -> currentDirection = Direction.SOUTH;
            case EAST -> currentDirection = Direction.NORTH;
        }
    }

    public void turnRight() {
        switch (currentDirection) {
            case NORTH -> currentDirection = Direction.EAST;
            case SOUTH -> currentDirection = Direction.WEST;
            case WEST -> currentDirection = Direction.NORTH;
            case EAST -> currentDirection = Direction.SOUTH;
        }
    }
}
