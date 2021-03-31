package q3ShijunWang;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayOfInts {
    private int[] data = new int[1]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    //--------------- new method: addAll ----------------
    public boolean addAll(int[] c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.length < 1) {
            return false;
        }
        for (int index = 0; index < c.length; index++) {
            if (data.length <= c.length) {
                growStorage();
            }
            data[size + index] = c[index];
        }
        size += c.length;
        return true;
    }
    //-----------------------------------------------------


    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == data.length) {
            growStorage();
        }
        data[size] = value;
        size++;
    }

    private void growStorage() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return data[index]; // complexity: o[1]
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(i == 0 ? "" : ", ");
            builder.append(data[i]);
        }
        builder.append("]");
        return builder.toString();
    }

}
