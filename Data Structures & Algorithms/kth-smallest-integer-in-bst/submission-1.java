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

    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        // 2, 3, 4, 5
        // 5
        dfs(root , k);

        return result;
    }

    public void dfs(TreeNode root,int k){
        if (root==null){
            return;
        }

        // in order traversal, left, root, right
        dfs(root.left,k);
        count++;
        if (count==k){
            result = root.val;
            return;
        }
        dfs(root.right,k);
        
        return;
    }
}
