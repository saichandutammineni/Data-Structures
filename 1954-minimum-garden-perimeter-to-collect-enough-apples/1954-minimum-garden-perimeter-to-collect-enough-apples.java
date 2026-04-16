class Solution {
    public long minimumPerimeter(long neededApples) {
        long l=1, r=(long)Math.pow(neededApples, 1.0/3);
        while(l<=r){
            long mid=l+(r-l)/2;

            long sum=2*mid*(mid+1)*(2*mid+1);
            
            if(sum<neededApples){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        
        return 8*(l);
    }
}