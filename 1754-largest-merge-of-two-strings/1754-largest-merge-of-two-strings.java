class Solution {
    public boolean isWord1Greater(String word1, int i, String word2, int j){

        while(i<word1.length() && j<word2.length() && word1.charAt(i)==word2.charAt(j)){
            i++;
            j++;
        }

        if(j==word2.length() || (i<word1.length() && word1.charAt(i)>word2.charAt(j))){
            return true;
        }
        return false;
    }
    public String largestMerge(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0, j=0;
        while(i<word1.length() && j<word2.length()){
            if(isWord1Greater(word1, i, word2, j)){
                sb.append(word1.charAt(i++));
            }
            else{
                sb.append(word2.charAt(j++));
            }
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }

        while(j<word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}