import sun.invoke.empty.Empty;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *  Stacks and Queues
 *
 *  Problem 3.1
 *
 *  Describe how you could use a single array to implement three stacks.
 *
 */
public class CTCI_3p1 {

    public static void main(String... args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        threeStacks(arr);
    }

    /**
     *  Algorithm Design
     *
     *  @param arr - array to create stacks out of
     *
     *  Split the array into 3 parts to use as individual stacks
     *  pop() - pop the top item off the stack
     *  push() - push a new item onto the stack
     *  peek() - look at the top of the stack
     *  isEmpty() - check if the stack is empty
     *
     */

    static void threeStacks(int[] arr) {
        int len = arr.length / 3;
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        int[] a3 = new int[len];

        // we need to consider the size of each individual array
        a1 = Arrays.copyOfRange(arr,0,len);
        a2 = Arrays.copyOfRange(arr,len,(len*2));
        a3 = Arrays.copyOfRange(arr,(len*2),arr.length);
    }

    static void print(int[] arr) {
        for(int item : arr) System.out.println(item);
    }

    static int pop(int[] arr) {
        if(arr.length == 0) throw new EmptyStackException();
        int item = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = -1;
        return item;
    }

    static void push(int[] arr, int val) {
        int countEmpty = 0;
        for(int item : arr) {
            if(item == -1) countEmpty++;
        }
        int countItems = arr.length - countEmpty;

        if(countItems == arr.length) throw new StackOverflowError(); // stack is full

        for(int i = arr.length - 1; i > 0; --i) {
            arr[i] = arr[i-1];
        }

        arr[0] = val; // push the val to the top of the stack
    }

    static int peek(int[] arr) {
        if(arr.length == 0 || arr[0] == -1) throw new EmptyStackException();
        return arr[0];
    }

    static boolean isEmpty(int[] arr) {
        if(arr.length == 0) throw new EmptyStackException();
        return arr[0] == -1 ? true : false;
    }

}
