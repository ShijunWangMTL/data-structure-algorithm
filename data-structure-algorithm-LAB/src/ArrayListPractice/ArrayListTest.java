package ArrayListPractice;

import java.util.ArrayList;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + name + ", " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Person> personArray = new ArrayList<>();
        personArray.add(new Person("Joe", 18));
        personArray.add(new Person("Jack", 28));
        personArray.add(new Person("John", 38));

        //Lambda Expression
       // personArray.forEach(person -> System.out.println(person));

        for (Person p : personArray) {
            System.out.println(p);
        }

        System.out.println("-------------------");
        Person p1 = personArray.get(1);
        System.out.println(p1);

        Person searchValue = new Person("Joe", 18);
        System.out.println(personArray.contains(searchValue));



    }


}
