/**
 *  Trees and Graphs
 *
 *  Problem 4.6
 *
 *  Write an algorithm to find the "next" node (i.e. in-order successor) of a given
 *  node in a binary search tree.  You may assume that each node has a link to its parent.
 *
 */
public class CTCI_4p6 {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.parent = root;
        root.right = new Node(10);
        root.right.parent = root;
        root.left.left = new Node(0);
        root.left.left.parent = root.left;
        root.left.right = new Node(3);
        root.left.right.parent = root.left;
        root.left.right.right = new Node(4);
        root.left.right.right.parent = root.left.right;
        root.right.left = new Node(7);
        root.right.left.parent = root.right;
        root.right.left.left = new Node(6);
        root.right.left.left.parent = root.right.left;
        root.right.left.right = new Node(8);
        root.right.left.right.parent = root.right.left;
        root.right.right = new Node(15);
        root.right.right.parent = root.right;
        root.right.right.left = new Node(12);
        root.right.right.left.parent = root.right.right;
        root.right.right.left.left = new Node(11);
        root.right.right.left.left.parent = root.right.right.left;
        root.right.right.left.right = new Node(13);
        root.right.right.left.right.parent = root.right.right.left;

        System.out.println(findNextNode(root.right.right.left.right).data);
    }

    static Node findNextNode(Node root) {
        if(root == null) return root;
        Node returnNode = root;

        // root node case
        if(root.parent == null) {
            if(root.right != null) returnNode = root.right;
            returnNode = null;
        }

        // parent node case
        if(root.left != null || root.right != null) {
            returnNode = parentNode(root);
        } else if (root == root.parent.left && (root.left == null && root.right == null)) {
            returnNode = leftLeaf(root);
        } else if (root == root.parent.right && (root.left == null && root.right == null)) {
            returnNode = rightLeaf(root);
        } else {
            throw new IllegalArgumentException();
        }
        return returnNode;
    }

    static Node parentNode(Node parent) {
        if(parent.right == null) return null;
        Node itr = parent.right;
        while(itr.left != null) {
            itr = itr.left;
        }
        return itr;
    }

    static Node leftLeaf(Node leftLeaf) {
        return leftLeaf.parent;
    }

    static Node rightLeaf(Node rightLeaf) {
        // bubble up the BST until we find the parent node that is greater
        Node curr = rightLeaf.parent;
        while(curr != null) {
            if(curr.data > rightLeaf.data) break;
            curr = curr.parent;
        }
        return curr;
    }

    static void printList(Node root) {
        if(root == null) return;
        printList(root.left);
        System.out.println(root.data);
        printList(root.right);
    }

    private static class Node {
        int data;
        Node parent;
        Node left, right;

        protected Node(int data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

}
