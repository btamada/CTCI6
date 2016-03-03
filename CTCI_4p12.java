import java.util.LinkedList;
import java.util.Queue;

/**
 *  Trees and Graphs
 *
 *  Problem 4.12
 *
 *  You are given a binary search tree in which each node contains an integer value
 *  (which might be positive or negative). Design an algorithm to count the number
 *  of paths that sum to a given value.  The path does not need to start or end at
 *  the root or leaf, but it must go downwards (traveling only from parent nodes
 *  to child nodes).
 *
 */
public class CTCI_4p12 {

    public static void main(String[] args) {
        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(12);
        root2.left.left = new Node(0);
        root2.left.right = new Node(4);
        root2.left.left.right = new Node(1);
        root2.left.right.left = new Node(3);
        root2.right.right = new Node(18);
        root2.right.right.left = new Node(14);
        root2.right.right.right = new Node(20);

        LinkedList<Node> ll = new LinkedList<>();

        // add the tree nodes to a queue in level order
        ll = addToQueue(root2,ll);

        int sumPaths = 0;

        int sumKeeper = 0;

        // iterate through the nodes in the queue
        for(Node n : ll) {
            sumPaths += sumPathsToValue(n, 7, 0);
        }

        System.out.println(sumPaths);
    }

    static int size(Node root) {
        int numNodes = 1;
        if(root == null) return 0;
        Node curr = null;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            Node itr = queue.remove();

            if(itr.left != null) {
                numNodes++;
                queue.add(itr.left);
            }

            if(itr.right != null) {
                numNodes++;
                queue.add(itr.right);
            }
        }

        return numNodes;
    }

    static LinkedList<Node> addToQueue(Node root, LinkedList<Node> ll) {
        if(root == null) throw new IllegalArgumentException();

        ll.add(root);

        for(int i = 0; i < size(root); ++i) {
            Node curr = ll.get(i);
            if(curr.left != null) ll.add(curr.left);
            if(curr.right != null) ll.add(curr.right);
        }

        return ll;
    }

    /**
     *
     * Algorithm Design
     *
     * @param root - the tree to search through
     * @param val - the value to sum
     * @return - the number of paths that sum up to the parameter val
     *
     *
     *
     */
    static int sumPathsToValue(Node root, int val, int sumKeeper) {
        if(root == null || val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) throw new IllegalArgumentException("Invalid Input");

        int validPaths = 0;

        if(sumKeeper == val) return 1;

        sumKeeper += root.data;

        if(root.left != null) validPaths += sumPathsToValue(root.left,val,sumKeeper);

        if(root.right != null) validPaths += sumPathsToValue(root.right,val,sumKeeper);

        return validPaths;
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
