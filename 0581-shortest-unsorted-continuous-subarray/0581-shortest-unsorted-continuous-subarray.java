class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // first iterate from left end , right end separately to find first wrong occurrence. then find min, max in middle subarray. now trace back to find element shorter than min(left side) and element higher than max(right side)
        
        //further optimized approach
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, r=-1, l=0, n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max) r=i; //issue case from left
            else max=nums[i];

            if(nums[n-1-i]>min) l=n-1-i; // issue case from right
            else min=nums[n-1-i];
        }

        return r-l+1;
    }
}