class Solution {
    public int maxProfit(int[] prices) {
        int res=0, buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            else if(prices[i]-buy >res){
                res=prices[i]-buy;
            }
        }
        return res;
    }
}