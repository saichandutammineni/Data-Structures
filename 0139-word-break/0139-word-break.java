class Solution {
    private int solve(String s, Integer[] dp, HashSet<String> set, StringBuilder sb, int index){
        if(index==s.length()){
            if(sb.length()==0) return 1;
            else return 0;
        }
        if(dp[index]!=null) return dp[index];

        int i=index;
        int temp=0;
        while(i<s.length()){
            sb.append(s.charAt(i++));
            if(set.contains(sb.toString())){
                temp |= solve(s, dp, set, new StringBuilder(""), i);
                if(temp==1) break;
            }
            
        }
        return dp[index]=temp;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder("");

        for(String s1: wordDict){
            set.add(s1);
        }
        Integer[] dp=new Integer[s.length()];
        return solve(s, dp, set, sb, 0)==1 ? true : false;
    }
}