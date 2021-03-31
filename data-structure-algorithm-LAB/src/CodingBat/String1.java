package CodingBat;

public class String1 {
    public static void main(String[] args) {
      //  System.out.println(lastTwo("ab"));
        String str="ab";
        str = str.substring(0,0); // null
        System.out.println(str.substring(0,0));


    }

    public String lastChars(String a, String b) {
        String str="";
        if (a.length() == 0){
            str ="@";
        }else {
            str = Character.toString(a.charAt(0));
        }
        if(b.length()==0){
            str+="@";
        }else{
            str+=Character.toString(b.charAt(b.length()-1));
        }
        return str;
    }

    public String conCat(String a, String b) {
        String str="";
        if(a.length()>0&&b.length()>0&&a.charAt(a.length()-1)==b.charAt(0)){
            str = a.concat(b.substring(1));
        }
        else {
            str=a.concat(b);
        }
        return str;
    }

    public static String lastTwo(String str) {
        if(str.length()>=2){
            str = str.substring(0,str.length()-2) + str.substring(str.length()-1, str.length()) + str.substring(str.length()-2, str.length()-1);
        }
        return str;
    }



}
