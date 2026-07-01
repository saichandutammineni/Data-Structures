class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        
        StringBuilder sb=new StringBuilder();

        // while(i>=0){
        //     if(freq[i]>0){
        //         int k=repeatLimit;
        //         while(k-->0 && freq[i]-->0){
        //             sb.append((char)('a'+i));
        //         }
        //         if(freq[i]>0 && i>0){
        //             int j=i-1;
        //             while(j>=0 && freq[j]==0){
        //                 j--;
        //             }
        //             if(j>=0){
        //                 freq[j]--;
        //                 sb.append((char)('a'+j));
        //             }
        //             else break;
        //         }
        //     }
        //     else{
        //     i--;
        //     }
        // }
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i]>0){
                int j=i-1;
                int k=repeatLimit;
                while(k-->0 && freq[i]-->0){
                    sb.append((char)('a'+i));

                    if(k==0 && freq[i]>0 && i>0){
                    
                        k=repeatLimit;
                        while(j>=0 && freq[j]==0){
                            j--;
                        }
                        if(j>=0){
                            freq[j]--;
                            sb.append((char)('a'+j));
                        }
                        else break;
                    }
                }
                
            }
        }

        return sb.toString();
    }
}