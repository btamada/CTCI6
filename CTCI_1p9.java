import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *  Arrays and Stings
 *  Problem 1.9
 *
 *  Assume you have a method isSubstring which check if one word is a substring of another.
 *  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
 *  one call to isSubstring e.g. "waterbottle" is a rotation of "erbottlewat"
 *
 *  Algorithm Design
 *  (1) - Sort characters and compare
 *  (2) - Loop through and compare each character in each string
 *  (3) - Create a char array and decrement
 */
public class CTCI_1p9 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        //System.out.println(isSubstringSort(s1,s2));
        //System.out.println(isSubstringCount(s1,s2));
        System.out.println(isSubstringCountArray(s1,s2));
    }

    /**
     * Time: O(nlogn)
     * Space: O(n)
     */
    static boolean isSubstringSort(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) return false;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        Arrays.sort(s1Char);
        Arrays.sort(s2Char);
        for(int i = 0; i < s1Char.length; ++i) {
            if(s1Char[i] != s2Char[i]) return false;
        }
        return true;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    static boolean isSubstringCount(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        for(char c : s1Char) {
            if(hm1.containsKey(c)) {
                int val = hm1.get(c);
                hm1.put(c,++val);
            } else {
                hm1.put(c,1);
            }
        }

        for(char c : s2Char) {
            if(hm2.containsKey(c)) {
                int val = hm2.get(c);
                hm2.put(c,++val);
            } else {
                hm2.put(c,1);
            }
        }

        Set<Character> myKeys = hm1.keySet();
        for(Character c : myKeys) {
            if(hm1.get(c) != hm2.get(c)) return false;
        }

        return true;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    static boolean isSubstringCountArray(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) return false;

        char[] s1Char = s1.toCharArray();

        int[] countArray = new int[256];

        for(int i = 0; i < s1Char.length; ++i)
            countArray[s1Char[i]] += 1;

        for(int i = 0; i < s2.length(); ++i) {
            if(countArray[s2.charAt(i)] <= 0) return false;
            countArray[s2.charAt(i)] -= 1;
        }
        return true;
    }

}
