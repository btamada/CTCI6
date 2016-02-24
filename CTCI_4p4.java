/**
 *  Trees and Graphs
 *
 *  Problem 4.4
 *
 *  Implement a function to check if a binary tree is balanced.  For the purposes of
 *  this question, a balanced tree is defined to be a tree such that the heights of
 *  the two subtrees of any node never differ by more than one.
 *
 */
public class CTCI_4p4 {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(100);
        root.left.right = new Node(20);
        root.right.left = new Node(0);
        root.right.right = new Node(3);
        root.right.right.right = new Node(99);
        System.out.println(isBalanced(root));
    }

    /**
     * Algorithm Design
     *
     * @param root - the root of the binary tree
     * @return - if the binary tree is balanced or not
     *
     * calculate the height of the left subtree
     * calculate the height of the right subtree
     *
     * find the difference and return true if heights differ by 1 or less else false
     *
     */
    static boolean isBalanced(Node root) {
        if(root == null) return false;
        return findHeight(root) <= 1 ? true : false;
    }

    static int findHeight(Node root) {
        if(root == null) return 0;
        return Math.abs(findHeight(root.left) + 1 - findHeight(root.right) + 1);
    }

    static void printList(Node root) {
        if(root == null) return;
        printList(root.left);
        System.out.println(root.data);
        printList(root.right);
    }

    private static class Node {
        int data;
        Node left, right;

        protected Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
