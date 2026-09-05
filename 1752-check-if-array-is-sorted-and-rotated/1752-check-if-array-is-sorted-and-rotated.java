class Solution {
    public boolean check(int[] nums) {
        boolean drop=false;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                if(drop) return false;
                drop=true;
            }
        }

        return true;
        


    
    }
}