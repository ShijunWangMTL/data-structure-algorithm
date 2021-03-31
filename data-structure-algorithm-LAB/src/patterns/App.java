package patterns;

public class App {

    public static void main(String[] args) {
        //Singleton s = new Singleton(); // cannot instantiate by a private constructor(private access)
        Singleton s = Singleton.getInstance();

        Singleton obj1 = Singleton.getInstance();
        obj1.showMsg();

        Singleton obj2 = Singleton.getInstance();
        obj2.showMsg();

    }
}
