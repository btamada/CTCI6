/**
 *  Arrays and Strings
 *  Problem 1.5
 *
 *  There are three types of edits that can be performed on strings: insert a character, remove a character,
 *  or replace a character.  Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 *  Ex.
 *  pale, ple -> true
 *  pales, pale -> true
 *  pale, bale -> true
 *  pale, bake -> false
 *
 */

import java.util.Scanner;

/**
 * Algorithm Design
 *
 * (1)
 * Time: O(N), Space: O(N)
 *
 * [check] the difference in lengths of the 2 strings is greater than 1 -> return false
 * convert the strings to character arrays
 * declare new array of length 256
 * loop through string 1 and count the frequencies of each character, insert them into the number array
 * loop through string 2
 *      check if the countDiff variable has exceeded 1
 *      check if we found a character in one string that is not in the other string
 *      if the character was found then decrement the frequency by 1
 * return true
 *
 */

public class CTCI_1p5 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String i1 = sc.nextLine().toLowerCase();
        String i2 = sc.nextLine().toLowerCase();
        System.out.println(stringEdit(i1,i2));
    }

    static boolean stringEdit(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        int[] numArr = new int[256];
        int countDiff = 0;
        for(char c : s1CharArr) {
            ++numArr[c];
        }

        for(char c : s2CharArr) {
            if(countDiff > 1) return false;
            if(numArr[c] <= 0) countDiff++;
            numArr[c] = numArr[c]--;
        }
        return true;
    }

}
