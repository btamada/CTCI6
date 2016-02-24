/**
 *  Trees and Graphs
 *
 *  Problem 4.2
 *
 *  Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a
 *  binary search tree with minimal height.
 *
 */
public class CTCI_4p2 {

    public static void main(String... args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        printBST(createBST(nums));
    }

    /**
     *  Algorithm Design
     *
     *  TC: O(N log N)
     *  SC: O(N)
     *
     */
    static Node createBST(int[] nums) {
        return insertIntoBST(nums, 0, nums.length-1);
    }

    static Node insertIntoBST(int[] nums, int start, int end) {
        if(end < start) return null;
        int mid = (start + end) / 2;
        Node n = new Node(nums[mid]);
        n.left = insertIntoBST(nums, start, mid - 1);
        n.right = insertIntoBST(nums, mid + 1, end);
        return n;
    }

    // print in-order traversal
    static void printBST(Node root) {
        if(root == null) return;
        printBST(root.left);
        System.out.println(root.val);
        printBST(root.right);
    }


    // the Node class
    private static class Node {
        int val;
        Node left, right;

        protected Node(int val) {
            this.val = val;
        }
    }

}
