package stack;

import java.util.EmptyStackException;

class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!firstName.equals(employee.firstName)) return false;
        return lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

}

public class ArrayStack {
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        //check for the resize
/*        if (isExisting(employee) != null) {
            Employee temp = isExisting(employee);
            temp.setFirstName(employee.getFirstName());
            temp.setLastName(employee.getLastName());
            return;
        }*/
        if (top == stack.length) {
            resize();
        }
        stack[top] = employee;
        top++;
    }

    private Employee isExisting(Employee employee) {
        for (int i = 0; i < top; i++) {
            if (employee.equals(stack[i]))
                return stack[i];
        }
        return null;
    }

    private void resize() {
        Employee[] temp = new Employee[top + 1];
        for (int i = 0; i < top; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
        // another way to resize
        Employee[] newArr = new Employee[stack.length *2];

    }

    public Employee pop() {
        //if it is empty throw EmptyStackException
        //return and decrease the size
        if (top == 0) {
            throw new EmptyStackException();
        }
        if (stack[top - 1] == null) {
            return null;
        }
        Employee emp = stack[top - 1];
        top--;
        //Employee emp = stack[--top];
        stack[top--] = null; // remove it
        return emp;
    }

    public Employee peek() {
        //if it is empty throw EmptyStackException
        //return the top of stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee emp = stack[top - 1];
        return emp;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("No value to print");
        } else {
            for (int i = top - 1; i >= 0; i--) {
                System.out.println(stack[i]);
            }

        }
    }
}
