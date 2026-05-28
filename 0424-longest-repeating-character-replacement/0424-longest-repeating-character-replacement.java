class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, res=0, maxFreq=0;
        int[] freq=new int[26];

        for(int j=0;j<s.length();j++){
            maxFreq=Math.max(maxFreq, ++freq[s.charAt(j)-'A']);

            while((j-i+1)-maxFreq >k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            res=Math.max(res, j-i+1);
        }
        return res;
    }
}