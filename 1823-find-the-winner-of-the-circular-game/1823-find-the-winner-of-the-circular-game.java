class Solution {
    public int findTheWinner(int n, int k) {
        // Approach 1: linkedList traversal deleting 1 node each time O(n*k)
        // Approach 2: Queue, popping and pushing (moving) k-1 nodes to end then deleting 1 node. O(n*k)

        // Approach 3: given below
        int temp=0; // index of the winner node will always be 0. 
        for(int i=2; i<=n;i++){
            temp=(temp+k)%i; // i is the size of problem set while constructing from size 2 to n

        }
        return temp+1;
    }
}