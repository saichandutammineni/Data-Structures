class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0], max=prices[0], ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else{
                ans=ans+prices[i]-min;
                min=prices[i];
            }
        }
        return ans;
    }
}