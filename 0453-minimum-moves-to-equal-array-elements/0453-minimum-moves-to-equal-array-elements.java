class Solution {
    public int minMoves(int[] nums) {
        int min=nums[0], ans=0;

        for(int i=1;i<nums.length;i++){
            min=Math.min(min, nums[i]);
        }

        for(int i: nums){
            ans+=i-min;
        }
        return ans;
    }
}