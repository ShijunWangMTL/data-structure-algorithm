package hashmap;

import java.security.Key;
import java.util.HashMap;
import java.util.*;

class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String message) {
        super(message);
    }
}

public class CustomHashMapStringString {
    private class Container {
        Container next;
        String key;
        String value;
    }

    private int arraySize = 5; // the size must be prime number
    private Container[] hashTable = new Container[arraySize]; //hashtable: an array of Container
    private int totalItems = 0;

    int getSize() {
        return totalItems;
    }

    void putValue(String key, String value) {
        // find which index of hashtable is proper to add the value
        int hashValue = computeHashValue(key);
        int index = hashValue % hashTable.length; // formula to find the index of the hashtable

        Container current = hashTable[index];
        //1 - container is not null because I need to check if the value exists in there or not
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Container newNode = new Container();
        newNode.value = value;
        newNode.key = key;
        //insert the node at the beginning of the hashtable selected index
        newNode.next = hashTable[index];
        hashTable[index] = newNode;
        totalItems++;

        //check the size of hashTable
        if (totalItems > 2 * hashTable.length) {
            resizeHashTable();
        }
    }

    //  expand hashTable by about *2 when totalItems > 2*hashTable.length
    private void resizeHashTable() {
        // the size needs to be a prime number
        arraySize = getNextPrime(arraySize);
        Container[] newHashTable = new Container[arraySize];
        for (int i = 0; i < hashTable.length; i++) {
            newHashTable[i] = hashTable[i];
        }
        hashTable = newHashTable;
    }

    // getNextPrime is only for finding next arraysize, not general
    private int getNextPrime(int number) {
        int num = number * 2;
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }

    private int computeHashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 1;  // same as: hash *= 2
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }

    // throw custom unchecked KeyNotFoundException
    String getValue(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        int index = hashValue % hashTable.length;

        Container curr = hashTable[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        throw new KeyNotFoundException("The key not found");
    }


    boolean hasKey(String key) {
        int hashValue = computeHashValue(key);
        int index = hashValue % hashTable.length;

        Container curr = hashTable[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // throw custom unchecked KeyNotFoundException
    void deleteByKey(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        int index = hashValue % hashTable.length;

        Container curr = hashTable[index];
        Container prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                break; // jump out of the loop
            }
            prev = curr;
            curr = curr.next;
        }
        // current is only null when I don't arrive to the upper loop
        // Or after the loop finishes I coun't find it
        if (curr == null) { //key not found at the end of navigation
            throw new KeyNotFoundException("The key is not there");
        }
        if (prev == null) { // remove the first item
            hashTable[index] = curr.next;
        } else {
            prev.next = curr.next;
        }
        totalItems--;
    }

    public String[] getAllKeys() {
        int index = 0;
        String[] result = new String[totalItems];
        for (int i = 0; i < hashTable.length; i++) {
            Container curr = hashTable[i];
            while (curr != null) {
                result[index] = curr.key;
                curr = curr.next;
                index++;
            }
        }
        return result;
    }

    // print hashTable content, see example below
    public void printDebug() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.printf("Entry %d: \n", i);
            Container curr = hashTable[i];
            while (curr != null) {
                System.out.printf(" - key %s, value %s \n", curr.key, curr.value);
                curr = curr.next;
            }
        }
    }

    @Override
    public String toString() {
        String[] keyArray = getAllKeys();
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < keyArray.length; i++) {
            try {
                String key = keyArray[i];
                String value = getValue(key);
                sb.append(i == 0 ? "" : ",");
                sb.append(key).append("-->").append(value);
            } catch (KeyNotFoundException e) {
                  System.out.println(e.getMessage());
            }
        }
        return sb.toString();
    } // comma-separated values->key pair list
    // to be able to use this as validation in Unit tests keys must be sorted
    // e.g. [ Key1 => Val1, Key2 => Val2, ... ]

    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }





}
///UNIT TESTS (required)
//Create JUnit tests, at least 10 of them to stress-test your implementation in all possible ways.
//
//
//AFTER:
//Once you got your implementation working make a copy of your code and modify it to turn it into a generic class:
//
//class class CustomHashMap<K,V> { ... }
//
//Example printDebug output:
//
//Entry 0:
//Entry 1:
//...
//Entry 3:
//- Key 11, Value: Abc
//Entry 4:
//...
//Entry 6:
//- Key 22, Value aaa
//- Key 86, Value zzz
