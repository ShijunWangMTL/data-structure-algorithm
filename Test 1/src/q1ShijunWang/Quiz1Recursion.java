package q1ShijunWang;

public class Quiz1Recursion {
    public String AddPound(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (str.length() <= 1) {
            return str;
        }
        str = str.substring(0, 1) + "#" + AddPound(str.substring(1));
        return str;
    }

}
