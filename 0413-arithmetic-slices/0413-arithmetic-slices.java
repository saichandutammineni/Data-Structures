class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int n=nums.length;

        int curr=0, res=0;
        for(int i=0;i<n-2;i++){
            if(nums[i+2]-nums[i+1]==nums[i+1]-nums[i]){
                curr++;
                res+=curr;
            }
            else{
                curr=0;
            }
        }
        return res;
    }
}