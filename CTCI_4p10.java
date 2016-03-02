import java.util.LinkedList;
import java.util.Queue;

/**
 *  Trees and Graphs
 *
 *  Problem 4.10
 *
 *  T1 and T2 are two very large binary trees, with T1 much bigger than T2.  Create an
 *  algorithm to determine if T2 is a subtree of T1.
 *  A tree T2 is a subtree of T2 if there exists a node n in T1 such that the subtree of n
 *  is identical to T2.  That is, if you cut off the tree at node n, the two trees would
 *  be identical.
 *
 */
public class CTCI_4p10 {

    public static void main(String... args) {
        Node t1 = new Node(5);
        t1.left = new Node(0);
        t1.right = new Node(10);
        t1.left.right = new Node(13);
        t1.right.left = new Node(2);
        t1.right.right = new Node(12);
        t1.right.right.left = new Node(18);
        t1.right.right.right = new Node(3);
        t1.right.right.right.left = new Node(7);

        Node t2 = new Node(12);
        t2.left = new Node(18);
        t2.right = new Node(3);
        t2.right.left = new Node(7);

        System.out.println(isSubtree(t1,t2));
    }

    /**
     *
     * Algorithm Design
     *
     * @param t1 - the bigger tree
     * @param t2 - the smaller tree
     * @return - if t2 a subtree of t1
     *
     *
     * 1) Search for the t2 root node in t1
     * 2) If found iterate through t2 and compare to t1, else return false
     * 3) As we iterate through t2 check if all nodes are equal to t1 nodes in the same location and return true, else false
     *
     */
    static boolean isSubtree(Node t1, Node t2) {
        if(t1 == null || t2 == null) throw new IllegalArgumentException("Invalid Input");

        Node t1Curr = null;

        Queue<Node> t1Queue = new LinkedList<>();

        t1Queue.add(t1);

        while(!t1Queue.isEmpty()) {

            t1Curr = t1Queue.remove();

            if(t1Curr.data == t2.data && itrTree(t1Curr,t2)) return true;

            if(t1Curr.left != null) t1Queue.add(t1Curr.left);

            if(t1Curr.right != null) t1Queue.add(t1Curr.right);

        }

        return false;
    }

    static boolean itrTree(Node t1, Node t2) {
        Node t1Curr = null;
        Node t2Curr = null;

        Queue<Node> t1Queue = new LinkedList<>();
        Queue<Node> t2Queue = new LinkedList<>();

        t1Queue.add(t1);
        t2Queue.add(t2);

        while(!t1Queue.isEmpty() && !t2Queue.isEmpty()) {

            t1Curr = t1Queue.remove();
            t2Curr = t2Queue.remove();

            if(t1Curr == null || t2Curr == null || (t1Curr.data != t2Curr.data)) return false;

            if(t1Curr.left != null || t2Curr.left != null) {
                t1Queue.add(t1Curr.left);
                t2Queue.add(t2Curr.left);
            }

            if(t1Curr.right != null || t2Curr.right != null) {
                t1Queue.add(t1Curr.right);
                t2Queue.add(t2Curr.right);
            }

        }

        return true;
    }

    static void printTree(Node root) {
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data);
        printTree(root.right);
    }

    private static class Node {
        int data;
        boolean visited;
        Node left, right;

        protected Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
