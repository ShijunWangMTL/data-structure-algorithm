package Arrays;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class App {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        int x = intArray.length;

        Person[] personArray = new Person[12];
        personArray[0] = new Person("A", 12);
        personArray[1] = new Person("B", 14);

        Person p = personArray[1];
        p.age = 20;

        System.out.println(personArray[1]);
        System.out.println(personArray[3]);  // null

        //Array Literal
        int[] arrLiteral = new int[]{1,2,3,4,5,6};

        //complexity => 0(n), take 0 step
        // how many steps to jump to implement. always count the worst case.
        for(int i=0;i<arrLiteral.length;i++) {
            System.out.print(arrLiteral[i] + " ");
        }
    }
}
