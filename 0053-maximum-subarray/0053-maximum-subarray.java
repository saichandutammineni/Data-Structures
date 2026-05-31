class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0], sum=nums[0];
        for(int i=1;i<nums.length;i++){
            // if(sum+nums[i]>nums[i]){
            //     sum+=nums[i];
            // }
            // else{
            //     sum=nums[i];
            // }
            sum=Math.max(nums[i], sum +nums[i]);
            res=Math.max(res, sum);
        }
        return res;
    }
}