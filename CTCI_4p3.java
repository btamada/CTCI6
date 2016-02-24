import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Trees and Graphs
 *
 *  Problem 4.3
 *
 *  Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if
 *  you have a tree with depth D, you'll have D linked lists).
 */
public class CTCI_4p3 {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(100);
        root.left.right = new Node(20);
        root.right.left = new Node(0);
        printArrayList(createLLDepths(root));
    }

    static void printArrayList(ArrayList<LinkedList<Node>> llDepths) {
        for(LinkedList<Node> ll : llDepths) {
            for(Node n : ll) {
                System.out.print(n.data + "->");
            }
            System.out.println();
        }
    }

    static void printList(Node root) {
        if(root == null) return;
        printList(root.left);
        System.out.println(root.data);
        printList(root.right);
    }

    /**
     *  Algorithm Design
     *
     *  create a method to take in the root of the binary tree
     *      create a new arraylist of linked lists to hold the nodes
     *
     *  create a method to iterate through the binary tree and store the nodes into the arraylist
     *      perform a BFS of the binary tree by storing the nodes into a queue
     *      iterate through the queue of nodes
     *          store the child nodes into the queue
     *          add the parent node into a new linked list
     *      add the new linked list to the array list
     *  return the array list of linked lists
     *
     */
    static ArrayList<LinkedList<Node>> createLLDepths(Node root) {
        ArrayList<LinkedList<Node>> llDepths = new ArrayList<LinkedList<Node>>();
        if(root == null) return llDepths;
        return createLLDepths(root,llDepths);
    }

    static ArrayList<LinkedList<Node>> createLLDepths(Node root, ArrayList<LinkedList<Node>> llDepths) {
        Queue<Node> queue = new LinkedList<>();
        int counter = 0;
        Node tmp;
        queue.add(root);
        while(!queue.isEmpty()) {
            counter = queue.size();
            LinkedList<Node> ll = new LinkedList<>();

            for(int i = 0; i < counter; ++i) {
                tmp = queue.remove();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                ll.add(tmp);
            }

            llDepths.add(ll);
        }
        return llDepths;
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
