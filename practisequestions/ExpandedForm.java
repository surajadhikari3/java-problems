package practisequestions;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Write a number in the expanded form
 * 25=2×10+5×1
 * 3913 = 3 x 1000 + 9 x 100 + 1 * 10 + 3
 **/
public class ExpandedForm {

    public void displayInExpandedForm(String stringInput) {
        StringBuilder expandedForm = new StringBuilder();
        int length = stringInput.length();
        for (int i = 0; i < length; i++) {
            expandedForm.append(stringInput.charAt(i)).append("*1").append("0".repeat(length-i-1)).append(i != (length - 1) ? "+" : "");
        }
        System.out.println("expanded form: " + expandedForm);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to find out the expanded form for:");
        new ExpandedForm().displayInExpandedForm(scanner.next());
        scanner.close();
    }
}
