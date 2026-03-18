class Solution {
    public int maxProfit(int[] prices) {
        int max=prices[0], min=prices[0], res=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                max=min;
            }
            else if(prices[i]>max){
                max=prices[i];
            }
            res=Math.max(max-min, res);
        }

        return res;
    }
}