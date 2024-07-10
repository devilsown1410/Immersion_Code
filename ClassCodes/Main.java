package ClassCodes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int edges[][]=new int[n-1][2];
        for(int i=0;i<n-1;++i) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;++i){
            graph.add(new ArrayList<Integer>());
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
        }

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        boolean flag=true;
        bfs_All(graph,n);
        for(int i=0;i<n;++i){
            if(res.get(i)!=arr[i]){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    public static void bfs_All(ArrayList<ArrayList<Integer>> graph,int V){
        boolean visited[]=new boolean[graph.size()];
        for(int i=0;i<V;++i){
            if(!visited[i]){
                res.add(i);
                visited[i]=true;
                bfs(graph,i,visited);
            }
        }
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph,int j,boolean visited[]){
        for(int k:graph.get(j)){
            if(!visited[k]){
                visited[k]=true;
                res.add(k);
                bfs(graph,k,visited);
            }
        }
    }
}
