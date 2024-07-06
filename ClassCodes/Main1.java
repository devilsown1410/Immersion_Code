package ClassCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1 {
    public static Integer[] parent;
    public static Integer[] rank;
    public static void initialize(int n) {
        parent=new Integer[n];
        rank= new Integer[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
            rank[i]=0;
        }
    }
    public static int find(int n){
        if(parent[n]==n){
            return n;
        }
        return parent[n]=find(parent[n]);
    }
    public static boolean union(int u,int v){
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v){
            return true;
        }
        if(rank[ulp_u]>rank[ulp_v]){
            parent[ulp_v]=ulp_u;
            rank[ulp_u]++;
        }
        else{
            parent[ulp_u]=ulp_v;
            rank[ulp_v]++;
        }
        return false;
    }
    public static void createAdjList(ArrayList<ArrayList<Integer>> graph,int V,int [][] edges){
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            edges[i][0] = Integer.parseInt(s[0]);
            edges[i][1] = Integer.parseInt(s[1]);
        }
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        createAdjList(graph, n, edges);
        initialize(n);
    }
}
