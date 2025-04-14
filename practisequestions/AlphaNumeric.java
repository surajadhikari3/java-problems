package practisequestions;

//Check if the input string is alphanumeric
public class AlphaNumeric {
    public boolean checkAlphaNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AlphaNumeric alphaNumeric = new AlphaNumeric();
        System.out.println("alpha-numeric: " + alphaNumeric.checkAlphaNumeric("dffdsfs"));
        System.out.println("alpha-numeric: " + alphaNumeric.checkAlphaNumeric("123213"));
        System.out.println("alpha-numeric: " + alphaNumeric.checkAlphaNumeric("HEllo@45"));
    }
}
