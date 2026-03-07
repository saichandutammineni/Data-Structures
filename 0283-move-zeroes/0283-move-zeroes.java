class Solution {
    private void swap(int[] nums, int i, int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
    public void moveZeroes(int[] nums) {
        int i=0, j=0;
        while(i<nums.length && j<nums.length){
            if(nums[i]!=0){
                i++;
                continue;
            }
            else if(nums[j]==0 || i>j){
                j++;
                continue;
            }
            else{
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }
}