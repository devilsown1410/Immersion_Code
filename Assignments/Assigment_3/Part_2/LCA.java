import java.util.ArrayList;
import java.util.List;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1=new ArrayList<>();
		
		List<TreeNode> l2=new ArrayList<>();
		
		if(!c(root,p,l1) ||!c(root,q,l2) ){
		    return null;
		}
		int i=0;
		while(i<l1.size() && i<l2.size()){
		    if(!(l1.get(i)==l2.get(i))){
		        break;
		    }
		    i++;
		}
		return l1.get(i-1);
	}
	public static boolean c(TreeNode root,TreeNode n,List<TreeNode> l){
	    if(root==null){
	        return false;
	    }
	    l.add(root);
	    if(root==n){
	        return true;
	    }
	    if(c(root.left,n,l)||c(root.right,n,l)){
	        return true;
	    }
	    l.remove(l.size()-1);
	    return false;
    }
}
