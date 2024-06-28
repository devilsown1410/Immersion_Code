import java.util.*;
public class DemoHeap{

    public static int left_child(int x){
        return 2*x+1;
    }
    public static int right_child(int x){
        return 2*x+2;
    }
    public static int parent(int x){
        return (x-1)/2;
    }
    public static void insert(ArrayList<Integer> heap,int key){
        heap.add(key);
        int curr=heap.size()-1;
        int parent=parent(curr);
        while(parent>=0 && heap.get(parent)>heap.get(curr)){
            int temp=heap.get(parent);
            heap.set(parent,heap.get(curr));
            heap.set(curr,temp);
            curr=parent;
            parent=parent(parent);
        }
    }
    public static void heapify(ArrayList<Integer> heap,int index,int size){
        int smallest=index;
        int left=left_child(index);
        int right=right_child(index);
        if(left<size && heap.get(left)<heap.get(smallest)){
            smallest=left;
        }
        if(right<size && heap.get(right)<heap.get(smallest)){
            smallest=right;
        }
        if(smallest!=index){
            int temp=heap.get(index);
            heap.set(index,heap.get(smallest));
            heap.set(smallest,temp);
            heapify(heap,smallest,size);
        }

    }
    public static int extract_min(ArrayList<Integer> heap){
        int size=heap.size();
        if(size==0){
            return Integer.MAX_VALUE;
        }
        if(size==1){
            return heap.remove(0);
        }
        int last=size-1;
        int temp=heap.get(0);
        heap.set(0,heap.remove(last));
        heapify(heap,0,heap.size());
        return temp;
    }
    public static void decreasekey(ArrayList<Integer> heap,int index,int key){
        heap.set(index,key);
        int parent=parent(index);
        while(parent>=0 && heap.get(parent)>heap.get(index)){
            int temp=heap.get(parent);
            heap.set(parent,heap.get(index));
            heap.set(index,temp);
            index=parent;
            parent=parent(index);
        }
    }
    public static void deletekey(ArrayList<Integer> heap,int index){
        decreasekey(heap,index,Integer.MIN_VALUE);
        extract_min(heap);
    }
    public static void arrtoheap(ArrayList<Integer> ans){
        for(int i=(ans.size()-2)/2;i>=0;i--){
            heapify(ans,i,ans.size()-1);
        }
    }
    public static void heapsort( ArrayList<Integer> ll, ArrayList<Integer> ans){
        int a=ll.size();
        for(int i=0;i<a;i++){
            extract_min(ll);
            ans.add(ll.get(ll.size()-1));
            ll.remove(ll.size()-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> heap=new ArrayList<>();
        // insert(heap,10);
        // insert(heap,20);
        // insert(heap,30);
        // insert(heap,40);
        // insert(heap,50);
        // insert(heap,60);
        // System.out.println(heap);
        insert(heap, 5);
        insert(heap, 20);
        insert(heap, 10);
        insert(heap, 50);
        insert(heap, 25);
        // heap.set(0,60);
        // System.out.println(heap);
        // heapify(heap, 0);
        System.out.println(heap);
        // extract_min(heap);
        // decreasekey(heap,1,2);
        deletekey( heap,2);
        System.out.println(heap);
    }
}