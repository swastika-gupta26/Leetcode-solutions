class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1){
            return nums[0];
        }
        //last house nai lenge , 0 to n-2 house we'll take
        int inc = nums[0];
        int exc=0;
        for(int i=1; i<n-1; i++){
           int ninc= nums[i]+exc;
            int nexc= Math.max(inc, exc);

            inc= ninc;
            exc= nexc;

        }
        int ans1 = Math.max(inc, exc);

        //last house lenge, we'll take 1 to n-1 houses
         int include = nums[1];
         int exclude= 0;
         for(int i=2; i<n; i++){
            int ninclude = nums[i]+exclude;
            int nexclude= Math.max(include, exclude);

            include= ninclude;
            exclude= nexclude;
         }
         int ans2= Math.max(include, exclude);

         return Math.max(ans1, ans2);

    }
}