package hashmap;

import java.util.*;

public class PersonAccountDemo {
    public static void main(String[] args) {
        HashMap<Person, List<Account>> personAccounts = new HashMap<>();
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("11111"));
        accounts.add(new Account("22222"));

        personAccounts.put(new Person("Tom"), accounts);

        for (Account account : accounts){
        // codes
        }

        String myname = "Jerry";
        var city = "Montreal";

        //var is a keyword for local variable
        for (var data:personAccounts.entrySet()){
            Person p = data.getKey();
            List<Account> account = data.getValue();
            System.out.println(p + " has -> " + account.size() + " accounts");
        }
        // var ==> Map.Entry<Person, List<Account>>
        for (Map.Entry<Person, List<Account>> data : personAccounts.entrySet()){
            Person p = data.getKey();
            List<Account> account = data.getValue();
            System.out.println(p + " has -> " + account.size() + " accounts");
        }
    }
}

class Person extends Object{
    String name;
    String age;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Account{
    String accNo;
    double balance;

    public Account(String accNo) {
        this.accNo = accNo;
    }
}