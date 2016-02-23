import java.util.Scanner;

/**
 * Walmart Interview Question - Staircase Problem
 *
 * 1) Write a function that gives all the possible combinations of either 1, 2 or 3
 * steps, in any order, to get to the 5th step, and returns the total number of combinations.
 *
 * 2) Rewrite the function so that order is not considered.
 *
 * Created by Bryan Tamada on 1/18/16.
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int steps = sc.nextInt();
        while(N-->0) {
            System.out.println("Number of combinations: ");
            System.out.print(numCombo(steps));
            System.out.println("Number of permutations: ");
            System.out.print(numPerms(steps));
        }
    }

    static int numCombo(int steps) {
        int combinations = 0;
        if(steps % 1 == 0) combinations++;
        if(steps % 2 == 0) combinations++;
        if(steps % 3 == 0) combinations++;

        return combinations;
    }

    static int numPerms(int steps) {
        int permutations = 0;
        if(steps % 1 == 0) permutations++;
        if(steps % 2 == 0) permutations++;
        if(steps % 3 == 0) permutations++;

        return permutations;
    }

}
