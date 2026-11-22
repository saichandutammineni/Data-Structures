class Solution {
    int ans=Integer.MAX_VALUE;

    private void solve(int[] jobs, long[] workers, int index){
        if(index<0){
            ans=Math.min(ans, (int)Arrays.stream(workers).max().getAsLong());
            return;
        }

        if((int)Arrays.stream(workers).max().getAsLong()>=ans) return;
        HashSet<Long> seen=new HashSet<>();

        for(int i=0;i<workers.length;i++){
            if(seen.contains(workers[i])) continue;
            seen.add(workers[i]);
            workers[i]+=(long)jobs[index];

            solve(jobs, workers, index-1);

            workers[i]-=(long)jobs[index];
        }
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        
        Arrays.sort(jobs);
        solve(jobs, new long[k], jobs.length-1);
        return ans==Integer.MAX_VALUE ? Arrays.stream(jobs).sum() : ans;
    }
}