class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        int i=0, max=nums[0];
        while(i<=max){
            if(max>=nums.length-1){
                return true;
            }
            max=Math.max(max, i+nums[i]);
            i++;
        }
        return false;
    }
}