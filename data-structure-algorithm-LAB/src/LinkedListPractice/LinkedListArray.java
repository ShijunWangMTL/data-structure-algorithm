package LinkedListPractice;

public class LinkedListArray<T> {
    /*    Once you got your implementation working make a copy of your code and modify it to turn it into a generic class:*/


    private class Container {
        Container next;
        T value;
    }

    private Container start, end;
    private int size;

    public void add(T value) {
        addToEnd(value);
    }

    private void addToFront(T value) {
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

    private void addToEnd(T value) {
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

    public T get(int index) {
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

    public void insertValueAtIndex(int index, T value) {
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
    public boolean deleteByValue(T value) {
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

/*    public T[] toArray() {
        return new T[]{};
        // 2nd solution

    }*/

}
