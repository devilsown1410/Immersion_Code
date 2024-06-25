public class isidentical {
    public class Node {
        int data;
        Node left;
        Node right;
         Node() {}
         Node(int val) { this.data = val; }
         Node(int val, Node left, Node right) {
             this.data = val;
            this.left = left;
             this.right = right;
         }
     }
	boolean isIdentical(Node root1, Node root2)
	{
	    return check(root1,root2);
	}
	public static boolean check(Node root1,Node root2){
	    if(root1==null && root2==null){
	        return true;
	    }
	    if(root1==null || root2==null){
	        return false;
	    }
	    if(root1.data!=root2.data){
	        return false;
	    }
	    return (check(root1.left,root2.left) &&check(root1.right,root2.right));
	}
	
}
