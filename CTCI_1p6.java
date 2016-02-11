import java.util.Scanner;

/**
 * Arrays and Strings
 * Problem 1.6
 *
 * Implement a method to perform basic string compression using the counts
 * of repeated characters.  For example, the string aabcccccaaa would become
 * a2b1c5a3.  If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.  You can assume the string
 * has only uppercase and lowercase letters (a - z).
 *
 * Algorithm Design
 *
 * check if the input string is null or has a length of 0
 * create a character array
 * create a counter container to hold the count of characters
 * create a container to hold the previous character to compare to the character in the current iteration
 * loop through the character array comparing the previous and current character
 *      if prev char minus curr char not equal to zero (different)
 *          add previous to the final string
 *          add the counter to the final string
 *          assign the curr character to temp var
 *          reset the counter back to zero
 *          continue on to the next iteration
 *      if prev minus curr is zero (same)
 *          add prev to the final string
 *          assign the curr character to the temp var
 *      add the last
 */
public class CTCI_1p6 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(stringCompression(input));
    }

    static String stringCompression(String input) {
        if(input == null || input.length() == 0) return input;
        StringBuilder sb = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        int counter = 1;
        char prev = inputCharArr[0];
        char curr = 0;
        for(int i = 1; i < inputCharArr.length - 1; ++i) {
            sb.append(prev);
            curr = inputCharArr[i];
            if(prev - curr != 0) {
                sb.append(counter);
                prev = curr;
                counter = 1;
                continue;
            }
            prev = curr;
            ++counter;
        }

        curr = inputCharArr[inputCharArr.length-1];
        if(prev - curr != 0) {
            sb.append(prev);
            sb.append(counter);
            sb.append(curr);
            sb.append(1);
        } else {
            sb.append(prev);
            sb.append(curr);
            sb.append(++counter);
        }

        return sb.toString();
    }

}
