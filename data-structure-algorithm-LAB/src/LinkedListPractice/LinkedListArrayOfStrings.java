package LinkedListPractice;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListArrayOfStrings {
    public static void main(String[] args) {
        LinkedListArrayOfStrings test = new LinkedListArrayOfStrings();
        test.add("1st");
        test.add("last");
        test.add("0");
        test.add("new last");
        test.add("n");
        test.insertValueAtIndex(5, "00");
        test.deleteByIndex(4);

//        test.deleteByValue("1st");
        System.out.println(test.toString());
/*        String[] arr = test.toArray();
        System.out.println(Arrays.toString(arr));*/
        System.out.println(test.getSize());
        System.out.println();
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        //System.out.println(test.get(5));
    }

    private class Container {
        Container next;
        String value;
    }

    private Container start, end;
    private int size=0;

    public void add(String value){
        addToEnd(value);
    }

    private void addToFront(String value) {
        Container newStart = new Container();
        newStart.value = value;
        if (start == null) {
            newStart.next = null;
            start = newStart;
            end = newStart;
        } else {
            newStart.next = start;
            start = newStart;
        }
        size++;
    }

    private void addToEnd(String value) {
        Container newEnd = new Container();
        newEnd.value = value;
        newEnd.next = null;
        if (start == null) {
            start = newEnd;
            end = newEnd;
            size++;
        } else {
            end.next = newEnd;
            end = newEnd;
            size++;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Container searchContainer = start;
        while (index > 0) {
            searchContainer = searchContainer.next;
            index--;
        }
        return searchContainer.value;
        // ???
        //throw new RuntimeException("Internal Error");
    }

    public void insertValueAtIndex(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // can check if index == size, considering complexity
        if (index == 0) {
            addToFront(value);
        } else {
            Container tobeInserted = new Container();
            tobeInserted.value = value;
            Container beforeInsert = start;
            while (index > 1) {
                beforeInsert = beforeInsert.next;
                index--;
            }
            tobeInserted.next = beforeInsert.next;
            beforeInsert.next = tobeInserted;
            size++;
        }

    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            start = start.next;
            size--;
        } else {
            Container beforeDelete = start;
            while (index > 1) {
                beforeDelete = beforeDelete.next;
                index--;
            }
            beforeDelete.next = beforeDelete.next.next;
            size--;
        }
    }

    // delete first value found
    public boolean deleteByValue(String value) {
        Container tobeDeleted = start;
        int index = 0;
        while (tobeDeleted != null) {
            if (tobeDeleted.value.equals(value)) {
                deleteByIndex(index);
                return true;
            }
            index++;
            tobeDeleted = tobeDeleted.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    // comma-separated values list similar to: [5,8,11]
    @Override
    public String toString() {
        if (start == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[" + start.value);
        Container container = start;
        while (container.next != null) {
            builder.append(", " + container.next.value);
            container = container.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public String[] toArray() {
        String str = toString().substring(1, toString().length() - 1);
        return str.split(", ");
        // 2nd solution


    }

}



