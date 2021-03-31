package stack;

import java.util.Arrays;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack empStack = new ArrayStack(3);
        empStack.printStack(); //No value to print
        empStack.push(new Employee("John", "Smith", 1));
        //empStack.printStack(); //
        empStack.push(new Employee("Tom", "Smith", 2));
        empStack.push(new Employee("Jerry", "Smith", 3));
        empStack.printStack(); //
    }
}
