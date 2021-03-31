package patterns;

public class Singleton {

    private static Singleton instance; // need check for instantiation in getInstance() method

    // can instantiate new Singletion, if no if() condition in getInstance() method
    //private static Singleton instance = new Singleton();
    int counter = 0;

    //private construcotr
    private Singleton(){
        counter++;
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void showMsg(){
        System.out.println("number of instances: " + counter); // counter will be always 1.
    }
}
