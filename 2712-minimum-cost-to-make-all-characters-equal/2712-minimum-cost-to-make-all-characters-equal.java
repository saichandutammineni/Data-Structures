class Solution {
    public long minimumCost(String s) {
        long cost=0;
        int n=s.length();

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                if(i<n/2){
                    cost+=i+1;
                }
                else{
                    cost+=n-i-1;
                }
            }
        }
        return cost;
    }
}