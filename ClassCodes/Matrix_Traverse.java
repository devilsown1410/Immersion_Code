package ClassCodes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Matrix_Traverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m= sc.nextInt();
        int n=sc.nextInt();
        int matrix[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean visited[][]=new boolean[m][n];
//        print(matrix,1,2,visited);
//        mat_dfs(matrix,0,0,visited);
//        bfs_traversal(matrix,0,0);
        mat_bfs_all(matrix);
    }



    public static void print(int[][] matrix,int i,int j,boolean visited[][]){
        if(visited[i][j]){
            return;
        }
        if(!visited[i][j]){
            visited[i][j]=true;
            System.out.println(matrix[i][j]);
            if(j+1<matrix[0].length){
                print(matrix,i,j+1,visited);
            }
            if(i+1<matrix.length) {
                print(matrix, i + 1, j, visited);
            }
            if(j-1>=0) {
                print(matrix, i, j - 1, visited);
            }
            if(i-1>=0) {
                print(matrix, i - 1, j, visited);
            }
        }
    }
    public static void mat_dfs(int[][] mat,int row,int col,boolean visited[][]){
        visited[row][col]=true;
//        System.out.println(mat[row][col]);
        System.out.println("{"+row+","+col+"}");
        int di[]={0,1,0,-1};
        int dj[]={1,0,-1,0};
        for (int i = 0; i < 4; i++) {
            int nbr_x=row+di[i];
            int nbr_y=col+dj[i];
            if(nbr_x>=0 && nbr_x < mat.length && nbr_y >= 0 && nbr_y < mat[0].length && !visited[nbr_x][nbr_y]){
                mat_dfs(mat,nbr_x,nbr_y,visited);
            }
        }

    }

    public static void bfs_traversal(int [][] mat,int row,int col,boolean [][] visited){
        int rows=mat.length;
        int cols=mat[0].length;
//        boolean visited[][]=new boolean[rows][cols];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{row,col});
        visited[row][col]=true;
        while(!q.isEmpty()){
            int []curr=q.poll();
            int curr_x=curr[0];
            int curr_y=curr[1];
            System.out.println("{"+curr_x+","+curr_y+"}");

//            System.out.println(mat[curr_x][curr_y]);
            int dx[]={0,1,0,-1};
            int dy[]={1,0,-1,0};
            for (int i = 0; i < 4; i++) {
                int nbr_x=curr_x+dx[i];
                int nbr_y=curr_y+dy[i];
                if(nbr_x>=0 && nbr_x < mat.length && nbr_y >= 0 && nbr_y < mat[0].length && !visited[nbr_x][nbr_y] && mat[nbr_x][nbr_y]==1){
                    q.add(new int[]{nbr_x,nbr_y});
                    visited[nbr_x][nbr_y]=true;
                }
            }

        }
    }
    public static void mat_bfs_all(int [][] mat){
        int rows=mat.length;
        int cols=mat[0].length;
        boolean visited[][]=new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j]==1 && !visited[i][j]){
                    System.out.println("Next Component ->");
                    bfs_traversal(mat,i,j,visited);
                }
            }
        }
    }
}
