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
    private boolean isBST(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        else if(!(root.val>min && root.val<max)){
            return false;
        }

        if(!isBST(root.left, min, root.val)){
            return false;
        }
        if(!isBST(root.right, root.val, max)){
            return false;
        }

        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}