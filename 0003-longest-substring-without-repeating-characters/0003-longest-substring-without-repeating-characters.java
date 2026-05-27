class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int i=0, res=0;
        for(int j=0;j<s.length();j++){
            if(hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) >=i){
                i=hm.get(s.charAt(j))+1;
                
            }
            else{
                
                res=Math.max(res, j-i+1);
            }
            hm.put(s.charAt(j), j);
        }
        return res;
    }
}