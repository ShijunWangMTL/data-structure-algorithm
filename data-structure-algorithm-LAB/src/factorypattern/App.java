package factorypattern;

public class App {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car car1 = factory.getCar(CarType.SUV);
        System.out.println(car1.calculateFuelUsage());
        Car car2 = factory.getCar(CarType.MiniSUV);
        System.out.println(car2.calculateFuelUsage());
    }
}
