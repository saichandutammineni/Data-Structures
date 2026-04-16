class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int i:nums){
            max=Math.max(max, i);
        }

        int l=1, r=max;
        while(l<=r){
            int mid=l+(r-l)/2;

            long divResult=0;
            for(int i:nums){
                divResult+=((i-1)/mid)+1;
            }

            if(divResult>threshold){
                l=mid+1;
            }
            else{
                r=mid-1;
            }

        }
        return l;
    }
}