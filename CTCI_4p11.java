import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *  Trees and Graphs
 *
 *  Problem 4.11
 *
 *  You are implementing a binary tree class from scratch which, in addition to
 *  insert, find, delete, has a method getRandom() which returns a random node from
 *  the tree.  All nodes should be equally likely to be chosen.  Design and implement
 *  algorithm for getRandomNode, and explain how you would implement the rest of the
 *  methods.
 *
 *  insert() - following a complete tree the function will fill the tree from left -> right
 *
 *  find() - traverse through the binary tree for the given number.  If found return true else false.
 *
 *  delete() - traverse through the binary tree for the given number.  If found delete it else do nothing.
 *
 */
public class CTCI_4p11 {

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

        Random rand = new Random();

        System.out.println(getRandom(t1,rand.nextInt(size(t1))));
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

    /**
     * Algorithm Design
     *
     * @param root - the root of the tree to search for
     * @return - the random integer
     *
     * 1) Generate a random number between 0 - numOfNodesInTheTree
     * 2) Traverse through the tree up until the random number
     * 3) Return the random number
     *
     */
    static int getRandom(Node root, int randNum) {
        if(randNum == 0) return root.data;

        Queue<Node> queue = new LinkedList<>();

        Node itr = null;

        queue.add(root);

        while(randNum > 0) {

            itr = queue.remove();

            if(itr.left != null) queue.add(itr.left);

            if(itr.right != null) queue.add(itr.right);

            randNum--;
        }

        return itr.data;
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
