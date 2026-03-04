class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ind=new int[26];
        for(int i=0;i<order.length();i++){
            ind[order.charAt(i)-'a']=i;
        }


        for(int i=0;i<words.length-1;i++){
            int m=0,n=0;
            while(m<words[i].length() && n<words[i+1].length()){
                if(words[i].charAt(m)!=words[i+1].charAt(n)){
                    if(ind[words[i].charAt(m)-'a']>ind[words[i+1].charAt(n)-'a']){
                        return false;
                    }
                    break;
                }
                m++;
                n++;
            }

            if(m==words[i+1].length() && words[i].length()>words[i+1].length()){
                return false;
            }
        }
        return true;
    }
}