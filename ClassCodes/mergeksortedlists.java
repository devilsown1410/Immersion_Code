import java.util.*;
class MyHeapNode implements Comparable<MyHeapNode>{
    int val,apos,bpos;
    public MyHeapNode(int v,int a,int vp){
        val=v;
        apos=a;
        bpos=vp;
    }
    @Override
    public int compareTo(MyHeapNode o) {
        return this.val-o.val;
    }
    
}
public class mergeksortedlists {
    public static ArrayList<Integer> mergek(ArrayList<ArrayList<Integer>>arr){
        ArrayList<Integer>res=new ArrayList<>();
        PriorityQueue<MyHeapNode>pq=new PriorityQueue<>();
        int k=arr.size();
        for(int i=0;i<k;i++){
            pq.add(new MyHeapNode(arr.get(i).get(0),i,0));
        }
        while(!pq.isEmpty()){
            MyHeapNode ele=pq.poll();
            res.add(ele.val);
            int apos=ele.apos;
            int bpos=ele.bpos;
            if(bpos+1<arr.get(apos).size()){
                pq.add(new MyHeapNode(arr.get(apos).get(bpos+1),apos,bpos+1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer>a1=new ArrayList<>(Arrays.asList(1,4,8));//   1 2 3
        ArrayList<Integer>a2=new ArrayList<>(Arrays.asList(2,3,10));   
        ArrayList<Integer>a3=new ArrayList<>(Arrays.asList(3,5,6));
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
         arr.add(a1);
         arr.add(a2);
         arr.add(a3);
         System.out.println(mergek(arr));
    }
}