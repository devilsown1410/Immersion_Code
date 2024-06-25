import java.util.LinkedList;
import java.util.Queue;

public class PopulatingRight{

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

    public Node connect(Node root) {
        check(root);
        return root;
    }
    public static void check(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            Node prev=null;
            for(int i=0;i<l;++i){
                Node temp=q.poll();
                if(prev!=null){
                prev.next=temp;}
                prev=temp;
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            
        }
        if(prev!=null){
            prev.next=null;
        }
    }
    }
}
