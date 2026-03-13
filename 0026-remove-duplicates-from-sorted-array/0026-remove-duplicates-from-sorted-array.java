class Solution {
    public int removeDuplicates(int[] nums) {
        int curr=nums[0], i=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]>curr){
                
                curr=nums[j];
                nums[i++]=curr;
            }
        }
        return i;
    }
}