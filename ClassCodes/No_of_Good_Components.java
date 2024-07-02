package ClassCodes;

import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        createAdjList(graph,v,edges);
        boolean visited[]=new boolean[v];
        int c=0;
        for(int i=0;i<v;++i){
            if(!visited[i]){
                ArrayList<Integer> ll=bfs(graph,i,visited);
                int p=0;
                for(int j=0;j<ll.size();++j){
                    if(graph.get(ll.get(j)).size()!=ll.size()-1){
                        p=1;
                    }
                }
                if(p==0){
                    c++;
                }
            }
        }
        return c;

    }
    public static void createAdjList(ArrayList<ArrayList<Integer>> graph,int V,int [][] edges){
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());

        }
        for (int[] edge : edges) {
            int u = edge[0]-1;
            int v = edge[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph,int s,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ll=new ArrayList<>();
//        Add Source to Queue
        q.add(s);
        visited[s]=true;
//        Traverse while q is not empty
        int d=graph.get(s).size();
        while(!q.isEmpty()){
            int curr=q.poll();
            ll.add(curr);
            for(int i:graph.get(curr)){
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return ll;
    }
}
