class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=piles[0]; // total hours

        for(int i=1;i<piles.length;i++){
            if(r<piles[i]){
                r=piles[i];
            }
        }

        while(l<r){
            int mid=l+(r-l)/2, th=0;
            for(int i=0;i<piles.length;i++){
                th+=(piles[i]+mid-1)/mid;
            }
            if(th<=h){
                r=mid;
            }
            else{
                l=mid+1;
            }
            
        }
        return l;
    }
}