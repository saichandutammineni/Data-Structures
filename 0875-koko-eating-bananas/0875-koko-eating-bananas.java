class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i:piles){
            max=Math.max(max, i);
        }

        int l=1, r=max;

        while(l<=r){
            int mid=l+(r-l)/2;
            
            long time=0;
            for(int i:piles){
                time+=((i-1)/mid)+1;
            }
            
            if(time>h){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}