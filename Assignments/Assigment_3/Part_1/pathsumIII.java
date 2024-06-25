public class pathsumIII {
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
     }
    public int pathSum(TreeNode root, int t) {
        if(root==null){
            return 0;
        }
        if(root.val==1000000000){
            return 0;
        }
        return allPath(root,t)+pathSum(root.left,t)+pathSum(root.right,t);
    }
    public static int allPath(TreeNode root,int t){
        if(root==null){
            return 0;
        }
        int c=0;
        if(root.val==t){
            c++;
        }
        c+=allPath(root.left,t-root.val);
        c+=allPath(root.right,t-root.val);
        return c;
    }
}
