package practisequestions;

import java.util.Scanner;

//Check if a given string is palindrome and provide the time complexity

public class Palindrome {
    public Boolean checkPalindrome(String input){
        int length = input.length();
        for (int i = 0; i < (length/2); i++) {
            if(input.charAt(i)!= input.charAt(length - i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word to check palindrome");
        String input = scanner.next();
        System.out.println(new Palindrome().checkPalindrome(input));
    }
}

/**
  Time complexity
 the loop runs from i = 0 to i < length /2 meaning it iterates approximately n/2 times,

 Best Case :
 When the first mismatched found early then the loop exits early which is O(1)...

 Average Case : The loop runs for about n/2 iterations before a mismatch is found. This still results sin o(n) complexity

 Worst Case :

 When the input string is a palindrome, meaning the loop runs completely

 Since the loop executes n/2 times, the total time complexity is O(n/2) ≈ O(n) (dropping constants in Big-O notation).

 **/
