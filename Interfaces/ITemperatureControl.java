package Interfaces;

public interface ITemperatureControl {
    double getCurrentTemperature();
    void setDesiredTemperature(double temperature);
    void turnOn();
    void turnOff();
    void setTemperatureBounds(double minTemperature, double maxTemperature);
}
