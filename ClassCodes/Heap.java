package ClassCodes;
import java.util.ArrayList;
import java.util.Scanner;
public class Heap {
    public static int left_child(int x){
        return 2*x+1;
    }
    public static int right_child(int x){
        return 2*x+2;
    }
    public static int parent(int x){
        return (x-1)/2;
    }

    public static  void insert(ArrayList<Integer> heap, int key){
        heap.add(key);
        int curr=heap.size()-1;
        int parent=parent(curr);
        while(curr>0 && heap.get(parent)>heap.get(curr)){
            int temp=heap.get(parent);
            heap.set(parent,heap.get(curr));
            heap.set(curr,temp);
            curr=parent;
            parent=parent(curr);
        }

    }

    public static void heapify(ArrayList<Integer> heap,int index,int size){
        int smallest=index;
        int right=right_child(index);
        int left=left_child(index);
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
            heapify(heap,smallest,heap.size());
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k=sc.nextInt();
            ArrayList<Integer> heap = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a=sc.nextInt();
                insert(heap,a);
            }
            int res=0;
        for (int i = 0; i < k; i++) {
            res=extract_min(heap);
        }
        System.out.println(res);
    }
}

