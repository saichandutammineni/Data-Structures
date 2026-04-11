class Solution {
    private int findRight(int[] nums, int l, int r, int target){
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]!=target)){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target && (mid==0 || nums[mid-1]!=target)){
                res[0]=mid;
                if(mid==nums.length-1 || nums[mid+1]==target){
                    res[1]=findRight(nums, mid, nums[r]!=target ? r : nums.length-1, target);
                }
                else{
                    res[1]=mid;
                }
                return res;
            }
            else if(nums[mid]>=target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
}