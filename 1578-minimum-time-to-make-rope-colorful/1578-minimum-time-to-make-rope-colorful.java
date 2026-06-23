class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0, cost=0;

        while(i<colors.length()){
            if(i<colors.length()-1 && colors.charAt(i)==colors.charAt(i+1)){
                int max=neededTime[i];
                cost+=max;
                while(i<colors.length()-1 && colors.charAt(i)==colors.charAt(i+1)){
                    
                    max=Math.max(max, neededTime[i+1]);
                    cost+=neededTime[i+1];
                    i++;
                }
            cost-=max; 
            }
            else{
                i++;
            }
        }
        return cost;
    }
}