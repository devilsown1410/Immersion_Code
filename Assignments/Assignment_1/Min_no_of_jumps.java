public class Min_no_of_jumps {
    static int minJumps(int[] arr, int n) {
        // your code here
        int steps = arr[0];
        int maxR = arr[0];
        int jumps = 1;
        
        if(n==1) return 0;
        if(arr[0] == 0) return -1;
        
        
        for(int i=1 ; i<n ; i++){
            if(i > maxR) return -1;
            if(i==n-1) return jumps;
            maxR = Math.max(maxR, arr[i] + i);
            steps--;
            if(steps == 0){
                jumps++;
                steps = maxR-i;
            }
            
        }
        return jumps;
    }   
}
