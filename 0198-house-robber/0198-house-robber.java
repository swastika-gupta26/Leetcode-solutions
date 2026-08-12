class Solution {
    public int rob(int[] nums) {
        int inc =nums[0];
        int exc =0;

        for(int i=1; i<nums.length; i++){
           int ninc= nums[i]+exc;
            int nexc= Math.max(inc, exc);

            inc= ninc;
            exc= nexc;

        }
        return Math.max(inc, exc);
    }
}