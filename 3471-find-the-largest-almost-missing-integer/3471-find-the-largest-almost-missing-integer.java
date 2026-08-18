class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> mp= new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<k; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(Integer x: mp.keySet()){
                count.put(x, count.getOrDefault(x,0)+1);
        }
        int left=0;
        int right=k;
        while(right<nums.length){
            if(mp.get(nums[left])>1){
               mp.put(nums[left], mp.get(nums[left])-1);
            }
            else{
                mp.remove(nums[left]);
            }
            mp.put(nums[right], mp.getOrDefault(nums[right], 0)+1);
            left++;
            right++;
            for(Integer x: mp.keySet()){
              
                count.put(x, count.getOrDefault(x,0)+1);
               
            }
        }
        int ans=-1;
        for(Integer x:count.keySet()){
            if(count.get(x)==1){
               ans= Math.max(ans, x);
            }
        }
        return ans;

        

    }
}