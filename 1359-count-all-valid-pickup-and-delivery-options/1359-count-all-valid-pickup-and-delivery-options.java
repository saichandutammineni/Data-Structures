class Solution {
    int MOD=1000000007;
    
    public int countOrders(int n) {
        long count=1, tot=2*n;
        for(int i=0;i<n;i++){
            count=(count*((tot)*(tot-1))/2)%MOD;
            tot-=2;
        }
        return (int)count%MOD;
    }
}