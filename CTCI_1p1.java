import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Arrays and Strings
 *
 * Problem 1.1
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 */
public class CTCI_1p1 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = new String(sc.nextLine());
        System.out.println(uniqueCharsNoDS(input));
        //System.out.println(uniqueCharsDS(input));
    }

    // O(N) since we are iterating over the hashmap twice
    // O(N) since we are storing the characters in the hashmap
    static boolean uniqueCharsDS(String input) {
        if(input == null || input.length() == 0) return false;
        char[] inputChar = input.toLowerCase().toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(Character c : inputChar) {
            if(hm.containsKey(c)) {
                int val = hm.get(c);
                hm.put(c,++val);
            } else  {
                hm.put(c,1);
            }
        }

        Set<Character> myKey = hm.keySet();
        for(Character c : myKey) if (hm.get(c) > 1) return false;
        return true;
    }

    // O(N) where N is the length of the string
    // O(1) since we are just using variables to store the chars
    static boolean uniqueCharsNoDS(String input) {
        if(input == null || input.length() == 0 || input.length() > 26) return false;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for(int i = 1; i <= input.length(); ++i){
            temp = sb.toString();
            CharSequence cs = input.substring(i-1,i);
            if(temp.contains(cs)) return false;
            else sb.append(cs);
        }
        return true;
    }

}
