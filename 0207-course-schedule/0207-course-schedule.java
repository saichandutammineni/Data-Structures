class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] c: prerequisites){
            adj.get(c[1]).add(c[0]);
            indegree[c[0]]++;
        }

        int count=0;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
            count++;
            q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int i: adj.get(curr)){
                indegree[i]--;

                if(indegree[i]==0){
                    q.offer(i);
                    count++;
                }
            }
        }

        return count==numCourses;
    }
}