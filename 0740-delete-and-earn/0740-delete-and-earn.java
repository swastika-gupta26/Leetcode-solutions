class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> mp= new HashMap<>();
         for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
         }
         int maxm=0;
         for(Integer x: mp.keySet()){
           maxm= Math.max(maxm, x);
         }
         int points[]= new int[maxm+1];
         for(Integer x:mp.keySet()){
            points[x]= x*mp.get(x);
         }

         int inc[]= new int[maxm+1];
         int exc[]= new int[maxm+1];

         for(int i=1; i<=maxm; i++){
            inc[i]= exc[i-1]+points[i];
            exc[i]= Math.max(exc[i-1], inc[i-1]);
         }
         return Math.max(exc[maxm], inc[maxm]);
    }
}