class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq=new int[20001];
        int maxFreq=0;
        for(int i:nums){
            freq[i+10000]++;
            maxFreq=Math.max(freq[i+10000], maxFreq);
        }

        List<Integer>[] buckets=new ArrayList[maxFreq+1];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new ArrayList<>();
        }

        for(int i=0;i<freq.length;i++){
            buckets[freq[i]].add(i-10000);
        }

        int[] res=new int[k];
        int count=0;
        for(int i=buckets.length-1;i>=0;i--){
            for(int j: buckets[i]){
                res[count++]=j;
                if(count==k){
                    return res;
                }
            }
        }
        return res;

    }
}