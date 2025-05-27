package practisequestions.leetcode.two.pointer;

public class ValidPalindrome125 {

    public static void main(String[] args) {
       String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }
    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < s1.length() / 2; i++) {
            if(s1.charAt(i) != s1.charAt(s1.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}
