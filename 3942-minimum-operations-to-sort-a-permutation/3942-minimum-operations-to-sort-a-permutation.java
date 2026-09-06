class Solution {
    public int minOperations(int[] nums) {
        boolean isIncreasing=true, isDecreasing=true;
        int n=nums.length, idx0=0;

        boolean drop=false;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                if(drop){
                    isIncreasing=false;
                    // break;
                }
                drop=true;
            }

            if(nums[i]==0) idx0=i;
        }

        drop=false;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[(i+1)%n]){
                if(drop){
                    isDecreasing=false;
                    break;
                }
                drop=true;
            }
            
        }

        if(!isDecreasing && !isIncreasing) return -1;
        int inc=Integer.MAX_VALUE, dec=Integer.MAX_VALUE;

        if(isDecreasing){
            int temp=n-1-idx0;
            inc=Math.min(idx0+1+1, temp+1);
        }
        if(isIncreasing){
            dec=Math.min(idx0, 1+n-1-idx0+2);
        }
        return Math.min(inc, dec);
    }
}