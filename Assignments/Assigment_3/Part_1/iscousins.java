
public class iscousins {
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
    static int depthx=-1;
    static int depthy=-1;
    static TreeNode parentx=null;
    static TreeNode parenty=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        check(root,null,x,y,0);
        return depthx==depthy && parentx!=parenty;
        
    }
    public static void check(TreeNode root,TreeNode parent,int x,int y,int depth){
        if(root==null){
            return;
        }
        if(root.val==x){
            parentx=parent;
            depthx=depth;
        }
        else if(root.val==y){
            parenty=parent;
            depthy=depth;
        }
        check(root.left,root,x,y,depth+1);
        check(root.right,root,x,y,depth+1);
    }
}

