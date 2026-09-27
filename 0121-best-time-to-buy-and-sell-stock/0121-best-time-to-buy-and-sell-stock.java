class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0, min=Integer.MAX_VALUE;

        for(int n:prices){
            if(min>n){
                min=n;
            }
            else if(min<n){
                maxProfit=Math.max(maxProfit, n-min);
            }
        }
        return maxProfit;
    }
}