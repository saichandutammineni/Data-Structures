class Solution {
    private int[] lps(int[] lps, String s){
        int i=1, j=0;

        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                lps[i]=j+1;
                j++;
                i++;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        return lps;
    }
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        String comb=s+"#"+rev;

        int[] lps=new int[comb.length()];
        lps(lps, comb);
        int longestPrefix=lps[comb.length()-1];
        String tobeAddedSuffix=s.substring(longestPrefix);
        return new StringBuilder(tobeAddedSuffix).reverse().toString()+s;
    }
}