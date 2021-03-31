package CodingBat;

import java.util.Locale;

public class String3 {
    public static void main(String[] args) {
        System.out.println(countYZ(""));
    }

    public static int countYZ(String str) {
        if (str.length()==0){
            return 0;
        }
       // str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ((Character.toLowerCase(str.charAt(i)) == 'y' || Character.toLowerCase(str.charAt(i)) == 'z') && !Character.isLetter(str.charAt(i + 1))) {
                count++;
            }
        }
        if (str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z') {
            count++;
        }
        return count;
    }

    public boolean equalIsNot(String str) {
if (str.length()<=5) {
    return false;
}
return false;
    }


}
