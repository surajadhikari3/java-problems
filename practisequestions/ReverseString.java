package practisequestions;

public class ReverseString {

    public String reverseString(String input) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            reversedString.append(input.charAt(input.length() - i-1));
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reversed String is: " + new ReverseString().reverseString("checkit"));
    }
}
