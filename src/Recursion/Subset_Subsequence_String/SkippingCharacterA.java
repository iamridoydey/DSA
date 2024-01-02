package Recursion.Subset_Subsequence_String;

public class SkippingCharacterA {
    public static void main(String[] args) {
        String ans = skip("baccad");
        String skip = skipApple("ridappleoyprappleite");
        System.out.println(skip);
    }

    public static String skipApple(String str) {
        if (str.equals("")){
            return str;
        }

        if (str.startsWith("apple")){
            return skipApple(str.substring(5));
        } else {
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    public static String skip(String str){
        if (str.equals("")){
            return str;
        }

        // if ch equal to a then remove it
        String ch = str.charAt(0) == 'a' ? "" : str.charAt(0)+"";

        return ch + skip(str.substring(1));
    }
}
