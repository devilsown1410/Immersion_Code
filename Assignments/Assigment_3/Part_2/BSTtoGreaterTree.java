import java.util.TreeSet;

public class BSTtoGreaterTree {
    public TreeNode bstToGst(TreeNode root) {
        TreeSet<Integer> st=new TreeSet<>();
        check(root,st);
        return check1(root,st);
    }
    public static void check(TreeNode root,TreeSet<Integer> st){
        if(root==null){
            return;
        }
        check(root.left,st);
        st.add(root.val);
        check(root.right,st);
    }
    public static TreeNode check1(TreeNode root,TreeSet<Integer> st){
        if(root==null){
            return null;
        }
        check1(root.left,st);
        int s=0;
        for(int i:st.tailSet(root.val)){
            s+=i;
        }
        root.val=s;
        check1(root.right,st);
        return root;
    }
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
}
