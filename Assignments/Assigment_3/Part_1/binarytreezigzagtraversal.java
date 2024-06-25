import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binarytreezigzagtraversal {
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
    static boolean flag=true;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        flag=true;
        List<List<Integer>> res=new ArrayList<>();
        
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<l;++i){
                TreeNode temp=q.poll();
                ll.add(temp.val);
            
            
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            }
            if(!flag){
                List<Integer> li=new ArrayList<>();
                for(int i=ll.size()-1;i>=0;--i){
                    li.add(ll.get(i));
                }
                res.add(li);
                flag=true;
            }
            else{
                res.add(ll);
                flag=false;
            }
        }
        return res;
    }
}
