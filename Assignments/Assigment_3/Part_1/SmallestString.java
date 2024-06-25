public class SmallestString {
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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest=new StringBuilder();
        dfs(root,new StringBuilder(),smallest);
        return smallest.toString();
    }
    public void dfs(TreeNode node,StringBuilder path,StringBuilder smallest){
        if(node==null){
            return;
        }
        path.append((char)('a'+node.val));
        if(node.left==null && node.right==null){
            String curr=path.reverse().toString();
            if(smallest.length()==0 || curr.compareTo(smallest.toString())<0){
                smallest.setLength(0);
                smallest.append(curr);
            }
            path.reverse();
        }
        dfs(node.left,path,smallest);
        dfs(node.right,path,smallest);
        path.setLength(path.length()-1);
    }
}
