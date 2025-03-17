package practisequestions;

//Check if the input string only contains number's
public class NumberCheck {

    public boolean checkIsNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberCheck numberCheck = new NumberCheck();
        System.out.println("Check digit: " + numberCheck.checkIsNumber("johncopder234324"));
        System.out.println("Check digit: " + numberCheck.checkIsNumber("23213123"));
        System.out.println("Check digit: " + numberCheck.checkIsNumber("joio0"));
    }
}
