package ClassCodes;

import java.util.Arrays;

public class Maximum_and_minimum {
    public static void main(String[] args) {
        int arr[]={2,4,6,3,7};
        Arrays.sort(arr);
        System.out.println(check(arr));
    }
    public static int check(int arr[]){
        int n=arr.length;
        return Math.min(Math.min(arr[n-1]-arr[3],arr[n-2]-arr[2]),Math.min(arr[n-3]-arr[1],arr[n-4]-arr[0]));
    }
}
