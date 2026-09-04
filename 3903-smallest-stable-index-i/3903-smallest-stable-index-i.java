class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxms[] = new int[n];

        for (int i = 0; i < n; i++) {
            int maxm = nums[0];
            for (int j = 0; j <= i; j++) {
                maxm = Math.max(maxm, nums[j]);
            }
            maxms[i] = maxm;
        }

        int minms[] = new int[n];
        for (int i = 0; i < n; i++) {
            int minm = nums[i];
            for (int j = i; j < n; j++) {
                minm = Math.min(minm, nums[j]);
            }
            minms[i] = minm;
        }
        int is[] = new int[n];
        int ans = -1;
    

        for (int i = 0; i < n; i++) {
            is[i] = maxms[i] - minms[i];
            if (is[i] <= k) {
                  return i;
            }
        }
        return -1;
    }
}