class Solution {
    private int solve(String s, Integer[] dp, HashSet<String> set, int index, StringBuilder sb){
        if(index==s.length()){
            if(sb.length()==0)
            return 1;
            else{
                return 0;
            }
        }

        if(dp[index]!=null){
            return dp[index];
        }
        int i=index;
        int temp=0;
        while(i<s.length()){
            sb.append(s.charAt(i++));
            if(set.contains(sb.toString())){
                temp|=solve(s, dp, set, i, new StringBuilder(""));
            }

        }
        return dp[index]=temp;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set=new HashSet<>();
        for(String s: words){
            set.add(s);
        }

        List<String> res=new ArrayList<>();
        for(String s: words){
            Integer[] dp=new Integer[s.length()];
            set.remove(s);
            if(solve(s, dp, set, 0, new StringBuilder(""))==1){
                res.add(s);
            }

            set.add(s);
        }

        return res;
    }
}