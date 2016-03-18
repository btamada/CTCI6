/**
 *  Sorting and Searching
 *
 *  Problem 10.3
 *
 *  Given an array that is sorted, but rotated find the given integer value.
 *
 *  Example:
 *  Input: {15,16,19,20,25,1,3,4,5,7,10,14}, 5
 *  Output: 8 (index of value 5)
 *
 */
public class CTCI_10p3 {

    public static void main(String... args) {
        int[] arr = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println(findNum(arr, 15));
        System.out.println(findNum(arr, 16));
        System.out.println(findNum(arr, 19));
        System.out.println(findNum(arr, 20));
        System.out.println(findNum(arr, 25));
        System.out.println(findNum(arr, 1));
        System.out.println(findNum(arr, 3));
        System.out.println(findNum(arr, 4));
        System.out.println(findNum(arr, 5));
        System.out.println(findNum(arr, 7));
        System.out.println(findNum(arr, 10));
        System.out.println(findNum(arr, 14));
    }

    /**
     *
     * Algorithm Design
     *
     * - Validate the input; arr and val parameters
     * -
     *
     * Things to Keep in Mind:
     * - val can be any real number
     * - check if we are passed in a null value or the arr.length == 0 (array empty)
     *
     * Approaches:
     * 1) When the element in the array is > val, then we iterate every other element.  When the element is
     * < val, then we iterate every element.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * 2) Use a Binary Search approach and only search through the section of the array that has the value
     * I am looking for.
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     * @param arr - the array to search through
     * @param val - the value to search for
     * @return - the index of the number
     */
    static int findNum(int[] arr, int val) {
        if(arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid Input");
        int first = 0;
        int last = arr.length - 1;
        int mid = 0;
        int result = 0;
        while(first < last) {
            mid = (first + last) / 2;

            // if we find the value in the array
            if(arr[mid] == val) {
                result = mid;
                break;
            } else if (arr[first] == val) {
                result = first;
                break;
            } else if (arr[last] == val) {
                result = last;
                break;
            }

            // reduce the search space
            if(arr[first] > val && arr[mid] < val)
                first = mid + 1;
            else if (arr[first] > val && arr[mid] > val)
                last = mid - 1;
            else if (arr[first] < val && arr[mid] < val)
                last = last - 1;
            else if (arr[first] < val && arr[mid] > val)
                last = mid - 1;
        }

        return result;
    }

}
