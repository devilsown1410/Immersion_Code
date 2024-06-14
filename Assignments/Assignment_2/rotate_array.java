class rotate_array {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n) {
        // add your code here
        int newar[] = new int[n];
        d = d%n;
        for(int i=0; i<n;i++){
            if(d > (n-1)){
                newar[i] = arr[d-n];
                d++;
            }
            else{
                newar[i] = arr[d];
                d++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = newar[i];
        }
    }
}