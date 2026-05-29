class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res=Math.abs(nums[0]), max=nums[0], min=nums[0];

        for(int i=1;i<nums.length;i++){
            // if(Math.abs(nums[i])> Math.abs(sum+nums[i])){
            //     sum=nums[i];
            // }
            // else{
            //     sum+=nums[i];
            // }
            max=Math.max(nums[i], max+nums[i]);
            min=Math.min(nums[i], min+nums[i]);


            res=Math.max(Math.max(Math.abs(max), Math.abs(min)), res);
        }
        return res;
    }
}