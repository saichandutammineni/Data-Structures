class Solution {
    int ans=0;
    int[] balance;

    private void dfs(int[][] requests, int index, int accepted){

        if(index==requests.length){
            for(int i:balance){
                if(i!=0) return;
            }
            ans=Math.max(ans, accepted);
            return;
        }

        dfs(requests, index+1, accepted);

        int from=requests[index][0], to=requests[index][1];

        balance[from]--;
        balance[to]++;
        dfs(requests, index+1, accepted+1);
        balance[from]++;
        balance[to]--;
    }

    public int maximumRequests(int n, int[][] requests) {
        balance=new int[n];
        int acceptedReq=0;
        dfs(requests, 0, acceptedReq);
        return ans;
    }
}