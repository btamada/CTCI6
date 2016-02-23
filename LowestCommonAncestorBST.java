public class LowestCommonAncestorBST {

    public static void main(String... foobar) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(lowestCommonAncestor(root,root.left.left,root.right.left).val);
        //printInOrder(root);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        // recurse through left subtree
        if(p.val < root.val && q.val < root.val) {
            lca = lowestCommonAncestor(root.left,p,q);
        }

        // recurse through the right subtree
        if(p.val > root.val && q.val > root.val) {
            lca =lowestCommonAncestor(root.right,p,q);
        }

        return lca == null ? root : lca;
    }



    static void printInOrder(TreeNode root) {
        // base case
        if(root == null) return;
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

}
