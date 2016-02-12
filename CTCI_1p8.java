import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Arrays and Strings
 *  Problem 1.8
 *
 *  Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 *  and column are set to 0.
 *
 *  Algorithm Design
 *
 *  Time: O(N^2)
 *  Space: O(N)
 *
 *  (1)
 *  check if the matrix is null
 *  loop through each row
 *      loop through each element in the row
 *          if element is zero
 *              keep a record of the row index
 *                  zero out the elements in the column
 */
public class CTCI_1p8 {

    public static void main(String... args) {
        int[][] matrix = {
                {1,2,3,4,0},
                {5,6,0,7,8},
                {9,10,11,12,13},
                {14,15,16,17,18},
        };

        setZeroNoExtraMatrix(matrix);

        print(matrix);
    }

    static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroNoExtraMatrix(int[][] matrix) {
        if(matrix == null) return;
        Queue<Integer> nums = new LinkedList<>();
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(matrix[i][j] == 0) {
                    Arrays.fill(matrix[i], 0); // zero out row
                    nums.add(j);
                    break;
                }
            }
        }
        zeroColumn(matrix, nums);
    }

    static void zeroColumn(int[][] matrix, Queue<Integer> nums) {
        if(matrix == null) return;

        while(!nums.isEmpty()) {
            int col = nums.poll();
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][col] = 0;
            }
        }
    }

}
