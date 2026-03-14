class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(mid+1<nums.length && nums[mid]<target && nums[mid+1]>target){
                return mid+1; 
            }
            else if(mid>0 && nums[mid]>target && nums[mid-1]<target){
                return mid;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}