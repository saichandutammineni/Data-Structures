class Solution {
    public long countVowels(String word) {
        int n=word.length();
        long ans=0;
        for(int i=0;i<n;i++){
            if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u'){
                ans+=(long)(i+1) * (long)(n-i);
            }
        }
        return ans;
    }
}