package lambda;

import jdk.dynalink.Operation;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class User{
    String name;
    String passport;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    boolean isValid(String name, String passport){
        return this.getName().equals(name) && this.getPassport().equals(passport);
    }
}

class Animal {
    private String name;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String name, boolean canHop, boolean canSwim) {
        this.name = name;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", canHop=" + canHop +
                ", canSwim=" + canSwim +
                '}';
    }
}

interface CheckTrait {
    boolean test(Animal a);
}

class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}
class CheckIfSwim implements CheckTrait {

    @Override
    public boolean test(Animal a) {
        return a.canSwim();
    }
}

public class App {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("fish", false, true));
        animalList.add(new Animal("Kangaroo", true, false));
        animalList.add(new Animal("rabbit", true, false));

        // traditional way
        print(animalList, new CheckIfHopper());
        print(animalList, new CheckIfSwim());
        System.out.println("-----------------------");

        // using Java 8 lambda expression, not requiring own interface.
        // use predicate interface instead
        print(animalList, a -> a.canHop());
        print(animalList, a -> a.canSwim());
        print(animalList, (Animal a) -> {
            return a.canHop();
        });
        System.out.println("-----------------------");

        // Java Lambda API for collections
        animalList.forEach(animal -> System.out.println(animal));
        System.out.println();
        animalList.forEach(animal -> {
            if (animal.canHop()){
                System.out.println(animal + " is a hopper");
            }
        });

        List<Animal> swimmerAnimals = animalList.stream().filter(a -> a.canSwim()).collect(Collectors.toList());
        animalList.removeIf(animal -> animal.canSwim());

        System.out.println("-----------------------");
        List<User> users = new ArrayList<>();
        User user1 = users.stream().filter(user -> user.isValid("John", "12345")).findFirst().get(); // NoSuchElementException: No value present
        User user2 = users.stream().filter(user -> user.isValid("John", "12345")).findFirst().orElse(null);
        users.stream().map(user -> {
            user.setName("tom");
            return user.getName();
        });

        System.out.println("-----------------------");
        // finding longest string
        List<String> names = Arrays.asList("John","Paul","Ringo");
/*        Optional<Operation> maxOp = names.stream()
                .map (name -> new Operation(name, name.length()))
                .max (Comparator.comparingInt(Operation::getLength()));
        Operation longest = maxOp.get();

        System.out.println(longest.getName() + " " + longest.getLength());
        //String longest = names.stream().max(Comparator.comparingInt(String::length));*/

    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal: animals) {
            // general test
            if(checker.test(animal)){
                System.out.println(animal + " ");
            }
        }
        System.out.println();



    }


}
