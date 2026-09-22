class Solution {
    public int minimumCoins(int[] prices) {
        int[] dp=new int[prices.length+1];

        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
            if(!dq.isEmpty() && 2*dq.getFirst()+1<i){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && dp[dq.getLast()]+prices[dq.getLast()]>=dp[i]+prices[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            dp[i+1]=dp[dq.getFirst()]+prices[dq.getFirst()];
        }
        return dp[prices.length];
    }
}