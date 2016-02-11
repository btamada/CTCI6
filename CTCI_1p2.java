import java.util.Scanner;

/**
 * Arrays and Strings
 * Problem 1.2
 *
 * Implement a function void reverse(char* str) in C or C++ which reverses a null terminated string
 */
public class CTCI_1p2 {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        reverse(input);
    }

    static void reverse(String input) {
        if(input == null || input.length() == 0) return;
        char[] inputChar = input.toCharArray();
        for(int i = 0; i < inputChar.length / 2; ++i) {
            swap(inputChar, i, inputChar.length - 1 - i);
        }
        System.out.println(new String(inputChar));
    }

    static void swap(char[] charArr, int i1, int i2) {
        char tmp = charArr[i1];
        charArr[i1] = charArr[i2];
        charArr[i2] = tmp;
    }
}
