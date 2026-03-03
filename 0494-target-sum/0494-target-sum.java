class Solution {
    int count=0;
    private void getWays(int[] nums, int target, int index, int sum){
        if(index==nums.length){
            if(sum==target){
                count++;
            }
            return;
        }

        getWays(nums, target, index+1, sum-(nums[index]));
        getWays(nums, target, index+1, sum+nums[index]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        getWays(nums, target, 0, 0);
        return count;
    }
}