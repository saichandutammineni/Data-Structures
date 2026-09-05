class Solution {
    public boolean check(int[] nums) {
        boolean drop=false;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                if(drop) return false;
                drop=true;
            }
        }

        return true;
        


    
    }
}