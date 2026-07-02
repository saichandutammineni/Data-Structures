class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length, count=0;
        if(n<3){
            return 0;
        }
        Arrays.sort(nums);

        for(int i=n-1;i>=0;i--){
            int l=0, r=i-1;

            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    count+=r-l;
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return count;
    }
}