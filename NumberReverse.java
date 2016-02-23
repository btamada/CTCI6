import java.util.Scanner;

/**
 * Created by Bryan Tamada on 1/8/16.
 */
public class NumberReverse {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to reverse: ");

        int original = input.nextInt();
        int reverse = 0;
        int remainder = 0;

        while(original != 0) {
            remainder = original % 10;
            reverse = reverse * 10 + remainder;
            original = original / 10;
        }

        System.out.println(reverse);
    }

}
