package ClassCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDemo {
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
         dfs_All(graph);
//        System.out.println(shortpath(graph,6));
//         bfs_All(graph);

//        dfs_All(graph);
//        int matrix[][]=n
//        ew int[n][n];
//        createAdjMatrix(matrix, m, edges);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
    public static void createAdjList(ArrayList<ArrayList<Integer>> graph,int V,int [][] edges){
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
            
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
//            graph.get(v).add(u);
        }
        System.out.println(graph);
    }

    public static void createAdjMatrix(int[][] matrix,int V,int [][]edges){
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            matrix[u][v]=1;
            matrix[v][u]=1;
        }
    }
    public static void bfs_All(ArrayList<ArrayList<Integer>> graph){
        int v=graph.size();
        int c=0;
        boolean visited[]=new boolean[graph.size()];
        for(int i=0;i<v;++i){
            if(!visited[i]){
                c++;
                bfs(graph,i,visited);
            }
        }
        System.out.println("\nNo.of connected Components "+c);
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph,int s,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
//        Add Source to Queue
        q.add(s);
        visited[s]=true;
//        Traverse while q is not empty
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int i:graph.get(curr)){
                if(!visited[i]) {
                    System.out.print(i+" ");
                    visited[i] = true;
                }
            }
        }

    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int s,boolean visited[],Stack<Integer> st){
        visited[s]=true;
//        System.out.println(s);
        ArrayList<Integer> nbr_list=graph.get(s);
        for(int nbr:nbr_list){
            if(!visited[nbr]){
                dfs(graph,nbr,visited,st);
            }

        }
        st.push(s);
    }
    public static void dfs_All(ArrayList<ArrayList<Integer>> graph){
        int V=graph.size();
        Stack<Integer> st=new Stack<>();
        boolean visited[]=new boolean[graph.size()];
        for(int i=0;i<V;++i){
            if(!visited[i]){
                dfs(graph,i,visited,st);
            }
        }
        System.out.println(st);
    }
    public static int shortest(int start,int end,ArrayList<ArrayList<Integer>> graph,boolean vst[],int c){
        if(start==end){
            return c;
        }
        vst[start]=true;
        int minlength=Integer.MAX_VALUE;
        for(int i:graph.get(start)){
            if(!vst[i]){
                int p=shortest(i,end,graph,vst,c+1);
                if(p!=-1){
                    minlength=Math.min(minlength,p);
                }
            }
        }
        vst[start]=false;
        return minlength==Integer.MAX_VALUE ?-1:minlength;
    }
    public static int shortpath(ArrayList<ArrayList<Integer>> graph,int end){
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < graph.size(); i++) {
            boolean vst[]=new boolean[graph.size()];
            int p=shortest(i,end,graph,vst,2);
            if(p!=-1){
                ans=Math.min(ans,p);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }




}