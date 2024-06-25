import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelsum {
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
    public int maxLevelSum(TreeNode root) {
        int m=Integer.MIN_VALUE;
        if(root==null)
        return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int a=0;
        int c=1;
        while(!q.isEmpty()){
            int l=q.size();
            int s=0;
            for(int i=0;i<l;++i){
                TreeNode t=q.poll();
                s+=t.val;
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null) q.add(t.right);
            }
            if(s>m){
                m=s;
                a=c;
            }
            c++;
        }
        return a;
    }
}
