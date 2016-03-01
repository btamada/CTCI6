import java.util.LinkedList;
import java.util.Queue;

/**
 *  Trees and Graphs
 *
 *  Problem 4.8
 *
 *  Design an algorithm and write code to find the first (lowest) common ancestor of
 *  two nodes in a binary tree.  Avoid storing nodes in a data structure.
 *  NOTE: This is not necessarily a BST.
 *
 */
public class CTCI_4p8 {

    /**
     *      Tree Representation
     *
     *             5
     *          /    \
     *        10      4
     *       /  \    /  \
     *           0      100
     *         /        /  \
     *        14       25   77
     *       /  \           \
     *      56  8          9001
     *           \
     *           69
     */

    public static void main(String... args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(4);
        root.left.right = new Node(0);
        root.left.right.left = new Node(14);
        root.left.right.left.left = new Node(56);
        root.left.right.left.right = new Node(8);
        root.left.right.left.right.right = new Node(69);
        root.right.right = new Node(100);
        root.right.right.left = new Node(25);
        root.right.right.right = new Node(77);
        root.right.right.right.right = new Node(9001);

        System.out.println(firstCommonAncestor(root,root.left.right.left.right.right, root.left.right.left.right).data);

    }

    /**
     *
     * Algorithm Design
     *
     * Case 1) if n1 and n2 are in separate subtrees then return root
     *      - determine the subtree we are in by the root (left vs right)
     *      - once we determine their locations we can return root as the FCA
     * Case 2) if the pair of nodes are in the same subtree
     *      - find out which node is higher up the tree
     *      - return the higher up node
     * Case 3) if the pair of nodes have the same value, return one of those values
     *
     *
     *
     *
     * @param root - root node
     * @param n1 - first node to search for
     * @param n2 - second node to search for
     * @return - the first common ancestor of the given pair of nodes
     */
    static Node firstCommonAncestor(Node root, Node n1, Node n2) {
        if(root == null || n1 == null || n2 == null) throw new IllegalArgumentException();

        // nodes are the same
        if(n1.data == n2.data) return n1;

        // nodes are in separate trees
        if( (searchInTree(root.left,n1) != null && searchInTree(root.right,n2) != null) || (searchInTree(root.left,n2) != null && searchInTree(root.right,n1) != null)) return root;

        // both nodes in the left subtree
        if(searchInTree(root.left,n1) != null && searchInTree(root.left,n2) != null) {
            if(searchTreeLevel(root.left,n1) > searchTreeLevel(root.left,n2)) return n2;
            if(searchTreeLevel(root.left,n1) < searchTreeLevel(root.left,n2)) return n1;
        }

        // both nodes in the right subtree
        if(searchInTree(root.right,n1) != null && searchInTree(root.right,n2) != null) {
            if(searchTreeLevel(root.right,n1) > searchTreeLevel(root.right,n2)) return n2;
            if(searchTreeLevel(root.right,n1) < searchTreeLevel(root.right,n2)) return n1;
        }

        return null;
    }

    static int searchTreeLevel(Node root, Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;

        int nodeCounter = 1;

        int innerCounter = 0;

        Node curr = null;

        while(!queue.isEmpty()) {

            for(int i = 0; i < nodeCounter; ++i) {
                curr = queue.remove();

                if(curr.data == node.data) return level;

                if(curr.left != null) {
                    queue.add(curr.left);
                    innerCounter++;
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                    innerCounter++;
                }
            }

            nodeCounter = innerCounter;

            innerCounter = 0;

            level++;

        }

        return level;
    }

    static Node searchInTree(Node root, Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        Node foundNode = null;

        Node curr = null;

        while(!queue.isEmpty()) {

            curr = queue.remove();

            if(curr.data == node.data) {
                foundNode = curr;
                break;
            }

            if(curr.left != null) queue.add(curr.left);

            if(curr.right != null) queue.add(curr.right);
        }

        return foundNode;
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
