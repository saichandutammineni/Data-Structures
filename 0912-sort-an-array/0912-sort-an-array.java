class Solution {
    public int[] sortArray(int[] nums) {
        int[] freq=new int[100001];
        for(int i:nums){
            freq[i+50000]++;
        }
        int k=0;
        for(int i=0;i<100001;i++){
            while(freq[i]>0){
                nums[k++]=i-50000;
                freq[i]--;
            }
        }
        return nums;
    }
}