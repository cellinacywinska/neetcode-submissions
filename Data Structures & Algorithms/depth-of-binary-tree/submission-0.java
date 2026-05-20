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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root==null) return 0;

        int a = 0;
        if (root.left!=null){
            a=dfs(root.left);
        }
       
        int b = 0;
        if (root.right!=null){
           b=dfs(root.right);
        }

        // +1 accounts for the current node, as it contributes to the current depth in the recursion call. 
        return 1+Math.max(a,b);
    }

}
