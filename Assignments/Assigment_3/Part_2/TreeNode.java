
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
    public boolean isSymmetric(TreeNode root) {
        return m(root.left,root.right);
    }
    private boolean m(TreeNode le,TreeNode ri){
        if(le==null && ri==null){
            return true;
        }
        if(le==null || ri==null){
            return false;
        }
        if(le.val!=ri.val){
            return false;
        }
        boolean l=m(le.left,ri.right);
        if(!l){
            return false;
        }
        boolean r=m(le.right,ri.left);
        return r;
    }
}