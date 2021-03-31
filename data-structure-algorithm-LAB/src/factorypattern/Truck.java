package factorypattern;

public class Truck implements Car{
    @Override
    public double calculateFuelUsage() {
        return 50;
    }
}
