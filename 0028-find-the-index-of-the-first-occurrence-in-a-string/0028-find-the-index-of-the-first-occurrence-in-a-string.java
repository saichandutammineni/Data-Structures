class Solution {
    private int[] getLps(String pattern){
        // set two variables at start
        int i=1, j=0; // j can also be called as length of prefix
        int[] lps=new int[pattern.length()];

        while(i<pattern.length()){
            if(pattern.charAt(j)==pattern.charAt(i)){
                lps[i]=j+1; // length starts with 1
                i++;
                j++;
            }
            else{
                if(j!=0){ // in case of a mismatch after finding some prefix
                    j=lps[j-1]; // reset j to lps of previous matching letter. In next iteration this new j will be compared again.
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        int[] lps=getLps(needle);
        int i=0,j=0;

        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    return i-j;
                    // if need to find all indices
                    // list.add(i-j);
					// j=lps[j-1]; // reset
                }
            }
            else{
                if(j!=0){
                    j=lps[j-1]; // reset j back
                }
                else{
                    i++;
                }
            }
        }

        return -1;
    }
}