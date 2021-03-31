package staticDemo;

public class StaticDemo
{
    static int x;
    public static void main(String[] args)
    {
        int objectCount;

        /*Countable obj1 = new Countable();
        Countable obj2 = new Countable();
        Countable obj3 = new Countable();
        Countable obj4 = new Countable();*/
        //Countable obj5 = new Countable();

       // x = obj5.getInstanceCount();
        System.out.println(x + " instances " +
                        "of the class were created.");

    }
}