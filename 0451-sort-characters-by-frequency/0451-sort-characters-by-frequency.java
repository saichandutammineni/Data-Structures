class Solution {
    public String frequencySort(String s) {
        int[] freq=new int[95];
        int maxFreq=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-' ']++;
            maxFreq=Math.max(maxFreq, freq[s.charAt(i)-' ']);
        }

        List<Character>[] bucket=new ArrayList[maxFreq+1];
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(int i=0;i<95;i++){
            bucket[freq[i]].add((char)(i+' '));
        }
        StringBuilder sb=new StringBuilder(); 
        for(int i=bucket.length-1;i>=0;i--){
            for(Character ch: bucket[i]){
                int temp=i;
                while(temp-->0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();

    }
}