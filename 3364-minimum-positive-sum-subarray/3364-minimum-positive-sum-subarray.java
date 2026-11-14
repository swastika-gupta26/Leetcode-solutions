class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min_sum = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int left = 0;
            int right = i + left - 1;
           
            while (right < nums.size()) {
                 int sum = 0;
                for (int j = left; j <= right; j++) {
                    sum = sum + nums.get(j);
                }
                if(sum > 0){
                min_sum = Math.min(min_sum, sum);
                }
                left++;
                right++;
            }
        }
        if(min_sum == Integer.MAX_VALUE){
            return -1;
        }
        else{
        return min_sum;
        }
    }
}