/**
 *  Trees and Graphs
 *
 *  Problem 4.5
 *
 *  Implement a function to check if a binary tree is a binary search tree.
 *
 */
public class CTCI_4p5 {

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(8);
        root1.right = new Node(2);
        root1.left.left = new Node(100);
        root1.left.right = new Node(20);
        root1.right.left = new Node(0);
        root1.right.right = new Node(3);
        root1.right.right.right = new Node(99);

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

        System.out.println(isBST(root2));

    }

    /**
     * Algorithm Design
     *
     * TC: O(N)
     * SC: O(N)
     *
     * Check if the left subtree is BST
     * Check if the right subtree is BST
     * Finally check if both subtrees are BST, and root child nodes abide by the BST rules
     *
     * @param root - the root of the binary tree to verify
     * @return - true if the left subtree is BST, right subtree is BST and left child <= root and right child > root
     */
    static boolean isBST(Node root) {
        if(root == null) return false;
        boolean leftSubTree = checkIfBST(root.left);
        boolean rightSubTree = checkIfBST(root.right);
        return (leftSubTree && rightSubTree == true) && root.left.data <= root.data && root.right.data > root.data ? true : false;
    }

    static boolean checkIfBST(Node root) {
        if(root.left != null) {
            if(root.left.data <= root.data) checkIfBST(root.left);
        } else if(root.right != null) {
            if(root.right.data > root.data) checkIfBST(root.right);
        } else {
            return false;
        }
        return true;
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
