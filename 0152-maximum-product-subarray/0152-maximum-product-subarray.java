class Solution {
    public int maxProduct(int[] nums) {
      
        int min =nums[0];
        int max= nums[0];
       int ans= nums[0];
        for(int i=1; i<nums.length; i++){
            
             int new_min= Math.min(nums[i], Math.min(nums[i]*min, nums[i]*max));
             int new_max= Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
             ans= Math.max(ans, new_max);
             min= new_min;
             max= new_max;
        }
        return Math.max(ans, max);
    }
}