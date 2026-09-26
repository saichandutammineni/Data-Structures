class Solution {
    
    private int solve(String s, HashSet<String> set, HashMap<String, Integer> hm){
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        
        StringBuilder sb=new StringBuilder(s);
        int temp=1;
        for(int i=0;i<s.length();i++){
            char ch=sb.charAt(i);
            sb.deleteCharAt(i);
            if(set.contains(sb.toString())){
                temp=Math.max(temp, 1+solve(sb.toString(), set, hm));
            }
            sb.insert(i, ch);
        }
        hm.put(sb.toString(), temp);
        return temp;
    }
    public int longestStrChain(String[] words) {
        int res=1;
        HashSet<String> set=new HashSet<>(Arrays.asList(words));
        HashMap<String, Integer> hm=new HashMap<>();

        for(String s: words){
            if(s.length()>1){
                res=Math.max(res, solve(s, set, hm));
            }
        }
        return res;
    }
}