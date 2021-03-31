package hashmap;

import java.util.*;

//HashSet, Tree, Stack and Queue
//SORT
//Design patterns : Singleton and factory and mvc and decorator

//hashcollision
// whenever 2 objects are equals their hashcode needs to be equals
//whenever 2 objects have the same hashcode, they can be equal or not
public class HashmapAddress {


    public static void main(String[] args) {
        // like a dictionary in C#
        // <key, value>
        HashMap<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "A");
        myMap.put(2, "B");

        HashMap<String, String> zipCodes = new HashMap<>();
        zipCodes.put("J4M", "Southshore");

        HashMap<String, Address> mapAddress = new HashMap<String, Address>();
        mapAddress.put("AAAAAA", new Address("111", "Main"));

        // test charWithFreq
        String str = "Geeksforgeeks";
        str = str.toLowerCase();
        charWithFreq(str);

    }
    static void charWithFreq(String str){
        HashMap<Character, Integer> freqOfChar = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (freqOfChar.containsKey(str.charAt(i))){
                freqOfChar.put(str.charAt(i), freqOfChar.get(str.charAt(i))+1);
            } else {
                freqOfChar.put(str.charAt(i), 1);
            }
        }
        for (var charFreq : freqOfChar.entrySet()) {
            System.out.println(charFreq.getKey() +" "+ charFreq.getValue());
        }

    }
}

class Address {
    private String StreetNo;
    private String street;

    public Address(String no, String str) {
        this.StreetNo = no;
        this.street = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return StreetNo.equals(address.StreetNo) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StreetNo, street);
    }
}
