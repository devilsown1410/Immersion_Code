package ClassCodes;

import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int V=sc.nextInt();
            int E=sc.nextInt();
            ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
            for(int i=0;i<V;++i){
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
        }
    }
}
class Pair implements Comparable<Pair>{
    int node;
    int distance;
    public Pair(int n,int d){
        node=n;
        distance=d;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distance-o.distance;
    }
}

class Solution{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj,int S) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S]=0;
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int curr_node=curr.node;
            int curr_dist=curr.distance;
            for(ArrayList<Integer> nbrs:adj.get(curr_node)){
                int nbr_node=nbrs.get(0);
                int nbr_wt=nbrs.get(1);
                if(dist[nbr_node]>curr_dist+nbr_wt){
                    dist[nbr_node]=curr_dist+nbr_wt;
                    pq.add(new Pair(nbr_node,dist[nbr_node]));
                }
            }

        }
        return dist;
    }

}
