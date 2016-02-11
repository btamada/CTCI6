import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays and String
 * Problem 1.3
 *
 * Given two strings, write a method to decide if one is a permutation
 * of the other.
 */
public class CTCI_1p3 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(isPermutationSlow(input1, input2));
        //System.out.println(isPermutation(input1, input2));
    }

    // O(NlogN + N)   // O(N)
    static boolean isPermutation(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        Arrays.sort(s1CharArr);
        Arrays.sort(s2CharArr);
        for(int i = 0; i < s1CharArr.length; ++i) {
            if(s1CharArr[i] != s2CharArr[i]) return false;
        }
        return true;
    }

    // O(N^2)
    // O(N)
    static boolean isPermutationSlow(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        int length = Math.max(s1.length(), s2.length());
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        int counter = 0;
        for(int i = 0; i < s1CharArr.length; ++i) {
            for(int j = 0; j < s2CharArr.length; ++j) {
                if(s1CharArr[i] == s2CharArr[j]) {
                    counter++;
                    continue;
                }
            }
        }
        return counter == length ? true : false;
    }
}
