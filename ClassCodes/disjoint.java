package ClassCodes;

import java.util.*;

public class disjoint {
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
    public static int Kruskal_Sort(int V,int [][]edges){
        int res=0;
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        for(int i=0;i<edges.length;++i){
            if(!union(edges[i][0],edges[i][1])){
                res+=edges[i][2];
            }
        }
        return res;
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
    public static void main(String[] args){
//        initialize(5);
//        union(1,2);
//        union(3,4);
//        union(2,5);
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        initialize(V);
        int e=sc.nextInt();
        int edges[][]=new int[e][3];
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j]=sc.nextInt();
            }
        }
        System.out.println(Kruskal_Sort(V,edges));
    }
}
