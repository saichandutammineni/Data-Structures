class Solution {
    private int solve(int[] nums, int med){
        int ans=0;

        for(int i:nums){
            ans+=Math.abs(med-i);
        }
        return ans;
    }
    public int minMoves2(int[] nums) {
        // int min=nums[0], max=nums[0];
        // for(int i: nums){
        //     min=Math.min(min, i);
        //     max=Math.max(max, i);
        // }

        // int diff=Integer.MAX_VALUE, realMed=0, median=(max+min)/2;
        // for(int i:nums){
        //     if(diff>Math.abs(median-i)){
        //         diff=Math.abs(median-i);
        //         realMed=i;
        //     }
        // }
        int n=nums.length;
        Arrays.sort(nums);
        if(n%2==0){
            return Math.min(solve(nums, nums[n/2]), solve(nums, nums[(n/2)-1]));
        }
        else{
            return solve(nums, nums[n/2]);
        }
        
    }
}