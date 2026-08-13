class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length];
        int overall_max=0;
        for(int i=0; i<nums.length; i++){
            int max_len=0;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    max_len= Math.max(max_len, dp[j]);
                }
            }
            dp[i]= max_len+1;
            overall_max= Math.max(overall_max, dp[i]);
        }
        return overall_max;
    }
}