class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        int diff= xor&(-xor);
        int s=0;
        int u=0;
        for(int i:nums){
            if((i&diff)>0){
                s^=i;
            }else{
                u^=i;
            }
        }
        int res[]={u,s};
        return res;
    }
}