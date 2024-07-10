public class InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode invertTree(TreeNode root) {
            check(root);
            return root;
        }
        public static void check(TreeNode root){
            if(root==null){
                return;
            }
            TreeNode t=root.right;
            root.right=root.left;
            root.left=t;
            check(root.left);
            check(root.right);
        }
    }
}
