import java.util.Scanner;

/**
 * Created by Bryan Tamada on 1/13/16.
 */
public class Quicksort {

    static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    static void quicksort(int[] arr, int lowerIndex, int upperIndex) {
        if(lowerIndex < upperIndex) {
            int p = partition(arr, lowerIndex, upperIndex);
            quicksort(arr, lowerIndex, p-1);
            quicksort(arr, p+1, upperIndex);
        }
    }

    static int partition(int[] arr, int lowerIndex, int upperIndex) {
        int pivotIndex = lowerIndex;
        int pivotValue = arr[pivotIndex];
        swap(arr,pivotIndex,upperIndex);
        int storeIndex = lowerIndex;

        for(int i = lowerIndex; i < upperIndex; ++i) {
            if(arr[i] < pivotValue) {
                swap(arr,i,storeIndex);
                storeIndex++;
            }
        }
        swap(arr,storeIndex,upperIndex);
        return storeIndex;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static void printArray(int[] ar, int lowerIndex, int upperIndex) {
        for(int i = lowerIndex; i <= upperIndex; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++) {
            ar[i]=in.nextInt();
        }
        quicksort(ar);
        //printArray(ar);
    }

}
