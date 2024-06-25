import java.util.ArrayList;
import java.util.List;

public class PathSumII {

// Definition for a binary tree node.
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
 
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        List<List<Integer>> ll=new ArrayList<>();
        check(root,t,ll,new ArrayList<>());
        return ll;
    }
    public static void check(TreeNode root,int t,List<List<Integer>> ll,List<Integer> li){
        if(root==null){
            return;
        }
        li.add(root.val);
        if(root.left==null && root.right==null && t==root.val){
            ll.add(new ArrayList<>(li));
        }
        else{
            check(root.left,t-root.val,ll,li);
            check(root.right,t-root.val,ll,li);
        }
        li.remove(li.size()-1);
    }
}
