package hashmap;

public class CustomHashMap {
    public static void main(String[] args) {

        CustomHashMapStringString hash = new CustomHashMapStringString();
        hash.putValue("1", "abc");
        hash.putValue("2", "FER");
        hash.putValue("3", "eee");
        hash.putValue("4", "ggg");
        hash.putValue("5", "abc");
        hash.putValue("6", "FER");
        hash.putValue("7", "eee");
        hash.putValue("8", "ggg");
        hash.putValue("9", "FER");
        hash.putValue("10", "eee");

        // resize has problem from No. 11
      //  hash.putValue("11", "ggg");
 //       hash.putValue("12", "ggg");
//        hash.putValue("12", "Reza");


        hash.printDebug();
        System.out.println("--------------");
        System.out.println(hash);

    }
}
