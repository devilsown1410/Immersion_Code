import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class OddEvenLEvel
{
	int getLevelDiff(Node root)
	{
	    //code here
	    List<List<Integer>> ll=levelOrder(root);
	    int s=0;
	    for(int i=0;i<ll.size();++i){
	        int r=0;
	        for(int j=0;j<ll.get(i).size();++j){
	            r+=ll.get(i).get(j);
	        }
	        if(i%2!=0){
	            s=s+(-1)*r;
	        }else{
	            s+=r;
	        }
	    }
	    return s;
	}
	public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        
        if(root==null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<l;++i){
                Node temp=q.poll();
                ll.add(temp.data);
            
            
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            }
            res.add(ll);
        }
        return res;
    }
}