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
    private int diameter=0; 
    private int findPath(TreeNode root){
        if(root==null) return 0;

        int l=findPath(root.left);
        int r=findPath(root.right);

        diameter=Math.max(diameter, l+r);
        return 1+Math.max(l, r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findPath(root);
        return diameter;

    }
}