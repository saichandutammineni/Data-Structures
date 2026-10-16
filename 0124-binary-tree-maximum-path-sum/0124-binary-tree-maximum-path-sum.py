# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def dfs(self, root: TreeNode) -> int:
        if root is None:
            return 0
        left=0
        right=0
        path=root.val
        if root.left:
            left=max(0, self.dfs(root.left))
        if root.right:
            right=max(0, self.dfs(root.right))
        self.mx=max(self.mx, left+right+root.val)
        return root.val+max(left, right) 

    def maxPathSum(self, root: TreeNode | None) -> int:
        self.mx=float('-inf')
        res=self.dfs(root)
        return max(self.mx,res)
        