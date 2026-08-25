class Solution {
    public int missingMultiple(int[] nums, int k) {

        int i = 1;
        while (i <= nums.length) {
            for (int j=0; j<nums.length; j++) {
                if (nums[j] == i * k) {
                    break;
                } else if (j == nums.length - 1 && nums[j] != i * k) {
                    return i * k;
                } else {
                    continue;
                }
            }

            i++;
        }

        return i * k;
    }
}
