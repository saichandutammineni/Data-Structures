class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int[] min=new int[prices.length];
        min[0]=prices[0];
        for(int i=1;i<prices.length;i++){    
            if(min[i-1]>prices[i]){
                min[i]=prices[i];
            }
            else{
                min[i]=min[i-1];
            }
        }

        for(int i=1;i<prices.length;i++){
            res=Math.max(res, prices[i]-min[i]);
        }
        return res;
    }
}