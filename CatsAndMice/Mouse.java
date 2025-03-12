package CatsAndMice;

public class Mouse {
    private double speed;

    public Mouse(double speed) {
        setSpeed(speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорость мыши должна быть положительной");
        }
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Мышь со скоростью " + speed + " м/с";
    }
}
