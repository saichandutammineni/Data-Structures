class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=0, min=0, res=0;

        for(int i=0;i<nums.length;i++){
            
            max=Math.max(Math.max(0,nums[i]), max+nums[i]);
            
            min=Math.min(Math.min(nums[i],0), min+nums[i]);


            res=Math.max(res, Math.max(max, min*-1));
        }
        return res;
    }
}