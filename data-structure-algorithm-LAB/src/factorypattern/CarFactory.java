package factorypattern;

public class CarFactory {
    public Car getCar(CarType carType){
        if (carType == CarType.SUV){
            return new Suv(); //upcasting
        }
        if (carType == CarType.MiniSUV){
            return new MiniSuv(); //upcasting
        }
        if (carType == CarType.Truck){
            return new Truck(); //upcasting
        }
        return null;
    }
}
