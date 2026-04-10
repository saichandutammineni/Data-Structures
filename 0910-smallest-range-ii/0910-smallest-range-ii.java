class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n=nums.length;
        if(n<2){
            return 0;
        }
        Arrays.sort(nums);

        int res=nums[n-1]-nums[0];

        for(int i=0;i<n-1;i++){
            res=Math.min(res, Math.max(nums[i]+k, nums[n-1]-k)-Math.min(nums[0]+k, nums[i+1]-k));
        }
        return res;
    }
}