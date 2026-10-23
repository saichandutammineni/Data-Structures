class Node{
    int age;
    int score;

    Node(int age, int score){
        this.age=age;
        this.score=score;
    }
}
class Solution {
    private int solve(int[] scores, int[] ages, Integer[][] dp, int prev, int curr){
        if(curr==ages.length) return 0;
        if(dp[prev+1][curr]!=null) return dp[prev+1][curr];

        int temp=0;
        if(prev==-1){
            temp=Math.max(scores[curr]+solve(scores, ages, dp, curr, curr+1), solve(scores, ages, dp, prev, curr+1));
        }
        else{
            temp=solve(scores, ages, dp, prev, curr+1);
            if(ages[prev]==ages[curr] || scores[prev]<=scores[curr]){
                temp=Math.max(temp, scores[curr]+solve(scores, ages, dp, curr, curr+1));
            }
        }

        return dp[prev+1][curr]=temp;

    }
    public int bestTeamScore(int[] scores, int[] ages) {
        PriorityQueue<Node> hm=new PriorityQueue<>((a,b)->{
            if(a.age==b.age) return Integer.compare(a.score, b.score);
            return Integer.compare(a.age, b.age);
            });
        int n=ages.length;
        for(int i=0;i<n;i++){
            hm.offer(new Node(ages[i], scores[i]));
        }
        int k=0;
        while(!hm.isEmpty()){
            Node t=hm.poll();
            ages[k]=t.age;
            scores[k]=t.score;
            k++;
        }

        Integer[][] dp=new Integer[n+1][n];
        return solve(scores, ages, dp, -1, 0);
    }
}