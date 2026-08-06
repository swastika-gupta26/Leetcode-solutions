class Solution {
    public List<List<Integer>>   ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> first= new ArrayList<>();
        helper(nums, first);
        return ans;
    }

    public void helper(int [] nums,  List<Integer> first){
        if(nums.length == 0){
           ans.add(new ArrayList<>(first));
           return ;
        }
        int roq[]= new int[nums.length-1];
        first.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            roq[i-1]= nums[i];
        }
       helper(roq, first);
        first.remove(first.size()-1);
       helper(roq, first );
    }
}