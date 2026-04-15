class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i:piles){
            max=Math.max(max, i);
        }

        int l=1, r=max, res=r;

        while(l<=r){
            int mid=l+(r-l)/2;
            
            int time=0;
            for(int i:piles){
                time+=Math.ceil((double)i/mid);
                if(time>h){
                    break;
                }
            }

            
            if(time>h){
                l=mid+1;
            }
            else{
                res=Math.min(res, mid);
                r=mid-1;
            }
        }
        return res;
    }
}