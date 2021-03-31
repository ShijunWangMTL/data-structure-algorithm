package charASCII;

public class App {
    public static void main(String[] args) {
        char c = 'a';
        int num = c; //97
        System.out.println(num + ", " + (num+1)); //97, 98
        int intchar = '1'; //49
        int intnum = 1;
        System.out.println(intchar==intnum); // false
        System.out.println("intchar: " + intchar);
        System.out.println("intnum: " + intnum);

        char charint = (char)intnum;
        char num1 = 'a'; //a
        char num2 = 'b'; //b
        char num3 = 88; // X
        int num4 = num3; //88
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);
        System.out.println("num4: " + num4);
        System.out.println(num1+num2);  // 195
         System.out.println("num1+num2: " + (num1+num2)); //195
        System.out.println("num1+num2: " + num1+num2); // ab
        System.out.println('a' + 'b'); // 195
        System.out.println(Character.toString('a') + Character.toString(num2));  // ab

        System.out.println(Character.toChars(88)); // X
        System.out.println(Character.toChars(86436438)); // error: IllegalArgumentException: Not a valid Unicode code point
    }
}
