import java.util.Scanner;

/**
 * Arrays and Strings
 * Problem 1.4
 *
 * Write a method to replace all spaces in a string with '%20'.  You may assume that the
 * string has sufficient space at the end of the string to hold the aditional characters,
 * and that you are given the "true" length of the string.  (Note: if implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 */
public class CTCI_1p4 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(replaceSpaces(input));
    }

    // O(N)
    // O(1)
    static String replaceSpaces(String input) {
        if(input == null || input.length() == 0) return "";
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < input.length(); ++i) {
            if(input.charAt(i) == ' ') {
                newString.append("%20");
                continue;
            }
            newString.append(input.charAt(i));
        }
        return newString.toString();
    }

}
