class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastOccurrence=new int[95];
        Arrays.fill(lastOccurrence, -1);
        int max=0, i=0, j=0;
        for(j=0;j<s.length();j++){
            if(lastOccurrence[s.charAt(j)-' ']<i){
                lastOccurrence[s.charAt(j)-' ']=j;
                continue;
            }
            
            max=Math.max(max, j-i);
            i=lastOccurrence[s.charAt(j)-' ']+1;
            lastOccurrence[s.charAt(j)-' ']=j;
        }
        return Math.max(max, j-i);
    }
}