package LinkedListPractice;

class Person{
    private String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class LinkedListArrayDemo {
    public static void main(String[] args) {
        LinkedListArray<Integer> integerlist = new LinkedListArray<>();
        integerlist.add(1);
        integerlist.add(2);

        LinkedListArray<Person> personlist = new LinkedListArray<>();
        personlist.add(new Person("John", 28));
        personlist.add(new Person("Joe", 48));

        System.out.println(integerlist.toString());

    }
}
