import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ll=new ArrayList<>();
        
        if(root==null){
            return ll;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;++i){
                Node temp=q.poll();
                if(i==0)ll.add(temp.data);
            
            
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            }
            
        }
        return ll;
    }

}

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

