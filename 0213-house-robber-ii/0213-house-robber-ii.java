class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }

    private int solve(int[] nums, int start, int end){
        if(end==start) return nums[start];
        int prev=nums[end];
        int max=Math.max(prev,nums[end-1]);
        for(int i=end-2;i>=start;i--){
            int temp=Math.max(nums[i]+prev, max);
            prev=max;
            max=temp;
        }

        return max;
    }
}