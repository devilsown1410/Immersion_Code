import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] nums) {
        int r=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            for(int j=0;j<nums.length;++j){
                map.put((nums[i]&nums[j]),map.getOrDefault((nums[i]&nums[j]),0)+1);
            }
        }for(int k=0;k<nums.length;++k){
            for(int key:map.keySet()){
                if((nums[k]&key)==0){
                    r+=map.get(key);
                }
            }
        }
        return r;
    }
}