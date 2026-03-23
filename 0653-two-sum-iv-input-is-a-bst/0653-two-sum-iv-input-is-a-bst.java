/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean twoSum(TreeNode root, int k, HashSet<Integer> hs){
        if(root==null) return false;
        if(hs.contains(k-root.val)) return true;
        hs.add(root.val);

        boolean l=twoSum(root.left, k, hs);
        boolean r=twoSum(root.right, k, hs);

        if(l || r){
            return true;
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs=new HashSet<Integer>();

        return twoSum(root, k, hs);
    }
}