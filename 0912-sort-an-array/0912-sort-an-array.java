class Solution {
    private int partition(int[] nums, int l, int r){
        int i=l-1, j=l;
        int pivot=l+(int)(Math.random()*(r-l+1));
        int t=nums[r];
        nums[r]=nums[pivot];
        nums[pivot]=t;

        for(; j<=r-1;j++){
            if(nums[j]<nums[r]){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        t=nums[i+1];
        nums[i+1]=nums[r];
        nums[r]=t;
        return i+1;
    }
    private void quickSort(int[] nums, int l, int r){
        if(l<r){
        int pi=partition(nums, l, r);
        quickSort(nums, l, pi-1);
        quickSort(nums, pi+1, r);
        }
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
}