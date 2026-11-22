class Solution {

    private boolean canAssign(int[] jobs, long[] workers, int index, long limit){
        if(index<0){
            return true;
        }

        HashSet<Long> seen=new HashSet<>();

        for(int i=0;i<workers.length;i++){
            if(seen.contains(workers[i])) continue;
            seen.add(workers[i]);
            if(workers[i]+(long)jobs[index]>limit) continue;
            workers[i]+=(long)jobs[index];

            if(canAssign(jobs, workers, index-1, limit)) return true;

            workers[i]-=(long)jobs[index];
        }
        return false;
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        
        Arrays.sort(jobs);
        int r=Arrays.stream(jobs).sum();
        int l=Arrays.stream(jobs).max().getAsInt();
        while(l<r){
            int mid=l+(r-l)/2;
            if(canAssign(jobs, new long[k], jobs.length-1, (long)mid)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        
        return l;
    }
}