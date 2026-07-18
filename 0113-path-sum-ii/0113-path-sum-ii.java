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
    private void getWays(TreeNode root, int target, List<List<Integer>> res, List<Integer> curr, int sum){
        if(root.left==null && root.right==null){
            if(sum==target){
                List<Integer> temp=new ArrayList<>(curr);
                res.add(temp);
            }
            return;
        }

        if(root.left!=null){
            curr.add(root.left.val);
            getWays(root.left, target, res, curr, sum+root.left.val);
            curr.remove(curr.size()-1);
            
        }
        if(root.right!=null){
            curr.add(root.right.val);
            getWays(root.right, target, res, curr, sum+root.right.val);
            curr.remove(curr.size()-1);
            
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<Integer> currList=new ArrayList<>();
        currList.add(root.val);
        getWays(root, targetSum, res, currList, root.val);
        return res;
    }
}