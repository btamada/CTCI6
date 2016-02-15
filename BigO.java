/**
 *  Cracking the Coding Interview
 *
 *  Various Big O Time Complexities
 *
 *  O(1) - Constant Time
 *
 *  O(n) - Linear Time
 *
 *  O(n + m) - Linear Time w/ 2 different arrays
 *
 *  O(nm) - Polynomial Time w/ 2 different arrays
 *
 *  O(logn) - Logarithm Time
 *
 *  O(nlogn) - Linear Logarithm Time
 *
 *  O(n^2) - Polynomial Time
 *
 *  O(n^3) - Cubed Time
 *
 *  O(2^n) - Nth Polynomial Time
 *
 *  O(n!) - Factorial Time
 *
 *  O(n^n) - N Polynomial N Time
 *
 */
public class BigO {

    // O(1) Constant Time
    static void constantTime(int a, int b) {
        System.out.println("The sum is: " + (a + b));
        System.out.println("The difference is: " + (a - b));
        System.out.println("The product is: " + (a * b));
        System.out.println("The quotient is: " + (a / b));
    }

    // O(n) Linear Time
    static void linearTime(int[] a) {
        if(a == null || a.length == 0) return;
        for(int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
    }

    // O(a + b) Linear Time w/ 2 Objects
    static void linearTimeTwoParams(int[] a, int[] b) {
        if(a == null || b == null || a.length == 0 || b.length == 0) return;

        for(int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }

        for(int i = 0; i < b.length; ++i) {
            System.out.println(b[i]);
        }
    }

    // O(nm) Polynomial Time w/ 2 Objects
    static void polyTimeTwoParams(int[] n, int[] m) {
        if(n == null || m == null || n.length == 0 || m.length == 0) return;
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < m.length; ++j) {
                System.out.println(n[i] + " " + m[j]);
            }
        }
    }

    // O(log n) Logarithm Time
    static int logTime(int[] n, int start, int end, int val) {
        if(n == null || n.length == 0) return -1;
        int mid = (start + end) / 2;
        if(val < n[mid]) logTime(n, 0, mid, val);
        if(val > n[mid]) logTime(n, mid + 1, n.length, val);
        return n[mid];
    }

    // O(n logn) Linear Logarithm Time
    static int linearLogTime(int[] n, int[] m) {
        if(n == null || n.length == 0 || m == null || m.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < n.length; ++i) {
            sum += logTime(m, 0, m.length, 15);
        }
        return sum;
    }

    // O(n**2), where n.length == m.length
    static void polyTime(int[][] n) {
        if(n == null || n.length == 0);
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < n[i].length; ++j) {
                System.out.println("The element is: " + n[i]);
            }
        }
    }

    // O(n**3)
    static long cubeTime(int[][] n, int[] m) {
        if(n == null || n.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < n[i].length; ++j) {
                for(int k = 0; k < m.length; ++k) {
                    sum += n[i][j] + n[i][j];
                }
            }
        }
        return sum;
    }

    // O(2**n) Nth Polynomial Time
    static int nthPolyTime(int n) {
        if(n <= 0) return -1;
        if(n == 1) return 1;
        return nthPolyTime(n - 1) + nthPolyTime(n - 2);
    }

    // O(n!) Factorial Time
    static int factorialTime(int n) {
        if(n <= 0) return -1;
        if(n == 1) return 1;
        return n * factorialTime(n - 1);
    }

    // O(n**n) N Polynomial N Time
    static long nPolyNTime(int[] n) {
        int temp = n.length;
        long sum = 0;
        if(n == null || n.length == 0) return -1;
        for(int i = 0; i < n.length; ++i) {
            while(temp --> 0) {
                for(int j = 0; j < n.length; ++j) {
                    sum += n[i] + n[j];
                }
            }
        }
        return sum;
    }
}
