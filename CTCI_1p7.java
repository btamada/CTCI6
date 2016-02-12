/**
 *  Arrays and Strings
 *  Problem 1.7
 *
 *  Given an image represented by an NxN matrix, where each pixel in the image
 *  is 4 bytes, write a method to rotate the image by 90 degrees.  Can you do this in place?
 *
 *  Algorithm Design
 *
 *
 *
 */
public class CTCI_1p7 {

    public static void main(String... args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        rotateMatrix(matrix);

        for(int[] row : matrix) {
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }

    static void rotateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        for(int i = 0; i < matrix.length / 2; ++i) {

        }
    }

}
